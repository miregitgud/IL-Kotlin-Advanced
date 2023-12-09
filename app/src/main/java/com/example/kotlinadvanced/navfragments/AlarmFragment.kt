package com.example.kotlinadvanced.navfragments

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.kotlinadvanced.R
import java.util.*

class AlarmFragment : Fragment() {

    private val EXACT_ALARM_PERMISSION_REQUEST_CODE = 123

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alarm, container, false)

        val btnSetAlarm: Button = view.findViewById(R.id.btnSetAlarm)
        btnSetAlarm.setOnClickListener {
            requestExactAlarmPermission()
        }

        return view
    }

    private fun requestExactAlarmPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val hasExactAlarmPermission = ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.SCHEDULE_EXACT_ALARM
            ) == PackageManager.PERMISSION_GRANTED

            if (!hasExactAlarmPermission) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        requireActivity(),
                        Manifest.permission.SCHEDULE_EXACT_ALARM
                    )
                ) {
                    // Explain the need for the permission and try again
                    Toast.makeText(
                        requireContext(),
                        "Permission is required to set exact alarms.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // Request the permission
                    requestPermissions(
                        arrayOf(Manifest.permission.SCHEDULE_EXACT_ALARM),
                        EXACT_ALARM_PERMISSION_REQUEST_CODE
                    )
                }
            } else {
                setAlarm()
            }
        } else {
            setAlarm()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == EXACT_ALARM_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can now set exact alarms
                setAlarm()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Permission denied. Please enable the permission in app settings.",
                    Toast.LENGTH_LONG
                ).show()

                // Open app settings for the user to enable the permission manually
                openAppSettings()
            }
        }
    }

    private fun openAppSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri: Uri = Uri.fromParts("package", requireContext().packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    private fun setAlarm() {
        val alarmManager =
            requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(requireContext(), AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            requireContext(),
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.add(Calendar.SECOND, 5) // Set the alarm to trigger after 5 seconds

        // Use setExactAndAllowWhileIdle for exact timing, even if the device is in idle mode
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )

        Toast.makeText(requireContext(), "Alarm set for 5 seconds", Toast.LENGTH_SHORT).show()
    }
}