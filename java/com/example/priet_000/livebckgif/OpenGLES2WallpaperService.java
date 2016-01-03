package com.example.priet_000.livebckgif;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.service.wallpaper.WallpaperService;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * Created by priet_000 on 11/7/2015.
 */
public abstract class OpenGLES2WallpaperService extends GIFWallpaperService {
    //public boolean held=false;
    @Override
    public Engine onCreateEngine() {
        return new OpenGLES2Engine();
    }
    public OpenGLES2WallpaperService getService(){
        return this;
    }
    class OpenGLES2Engine extends GLEngine{
        /*@Override
        public void onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
            if(event.getAction()==MotionEvent.ACTION_UP){
                held=false;
            }
            else{
                held=true;
            }
            x=(int)event.getX();
        }*/

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            // Check if the system supports OpenGL ES 2.0.
            final ActivityManager activityManager =
                    (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            final ConfigurationInfo configurationInfo =
                    activityManager.getDeviceConfigurationInfo();
            final boolean supportsEs2 =configurationInfo.reqGlEsVersion >= 0x20000;
            if (supportsEs2)
            {
                // Request an OpenGL ES 2.0 compatible context.
                setEGLContextClientVersion(2);

                // On Honeycomb+ devices, this improves the performance when
                // leaving and resuming the live wallpaper.
                setPreserveEGLContextOnPause(true);

                // Set the renderer to our user-defined renderer.
                setRenderer(getNewRenderer());
            }
            else
            {
                // This is where you could create an OpenGL ES 1.x compatible
                // renderer if you wanted to support both ES 1 and ES 2.

                return;
            }
        }
    }
    abstract Renderer getNewRenderer();
}
