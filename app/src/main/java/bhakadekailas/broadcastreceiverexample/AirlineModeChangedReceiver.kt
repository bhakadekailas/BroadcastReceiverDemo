package bhakadekailas.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AirlineModeChangedReceiver : BroadcastReceiver() {

    private val TAG: String = "AirlineModeChangedReceiver"

    override fun onReceive(context: Context, intent: Intent) {
        Log.e(TAG, "onReceive: ")
        val isAirplaneModeEnabled = intent.getBooleanExtra("state", false) ?: return
        if (isAirplaneModeEnabled) {
            Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_LONG).show()
        }
    }
}