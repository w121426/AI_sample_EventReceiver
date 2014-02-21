package csci567.eventreceiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class receiver extends BroadcastReceiver {
    private NotificationManager mNotificationManager;
	public static final int NOTIFICATION_ID = 1;
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		if (action.equals(Intent.ACTION_TIME_TICK)) {
			sendNotification(context,"Time Tick");
			Toast.makeText(context, "Time TIck", Toast.LENGTH_LONG).show();                     
		}
	}
    private void sendNotification(Context context, String msg) {
        mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
    
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
            new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder = 
        	new NotificationCompat.Builder(context)
        		.setSmallIcon(R.drawable.ic_launcher)
        		.setContentTitle("Notification")
        		.setStyle(new NotificationCompat.BigTextStyle()
        		.bigText(msg))
        		.setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}
