package in.zollet.abhilash.sample;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Abhilash on 10/6/2016.
 */

public class TestApplication extends Application implements Application.ActivityLifecycleCallbacks {
    boolean applicationOnPause = false;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
    }


    @Override
    public void onActivityCreated(Activity arg0, Bundle arg1) {
        Log.e("", "onActivityCreated");
        Toast.makeText(getApplicationContext(), "onActivityCreated", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.e("", "onActivityDestroyed ");
        Toast.makeText(getApplicationContext(), "onActivityDestroyed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivityPaused(Activity activity) {
        applicationOnPause = true;
        Log.e("", "onActivityPaused " + activity.getClass());
        Toast.makeText(getApplicationContext(), "onActivityPaused " + activity.getClass(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivityResumed(Activity activity) {
        applicationOnPause = false;
        Log.e("", "onActivityResumed " + activity.getClass());
        Toast.makeText(getApplicationContext(), "onActivityResumed " + activity.getClass(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.e("", "onActivitySaveInstanceState");
        Toast.makeText(getApplicationContext(), "onActivitySaveInstanceState", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.e("", "onActivityStarted");
        Toast.makeText(getApplicationContext(), "onActivityStarted", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.e("", "onActivityStopped");
        Toast.makeText(getApplicationContext(), "onActivityStopped", Toast.LENGTH_SHORT).show();

    }
}
