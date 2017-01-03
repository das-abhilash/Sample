package in.zollet.abhilash.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Abhilash on 9/29/2016.
 */

public class SmsReceiver extends BroadcastReceiver {

    private static SmsListener mListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle data  = intent.getExtras();

        Object[] pdus = (Object[]) data.get("pdus");
        String format = data.getString("format");

        for(int i=0;i<pdus.length;i++){

            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = myBundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
            } else {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }*/
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]/*,format*/);

            String sender = smsMessage.getDisplayOriginatingAddress();
            //You must check here if the sender is your provider and not another one with same text.

            String messageBody = smsMessage.getMessageBody();
            Toast.makeText(context,sender +  " : Message: "+messageBody,Toast.LENGTH_LONG).show();
            //Pass on the text to our listener.
            mListener.messageReceived(messageBody);
        }

    }

    public static void bindListener(SmsListener listener) {
        mListener = listener;
    }
}
