// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.celab.kyic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;


//import com.science6.util.Logger;

public class SplashActivity extends Activity
{

    private final String TAG = getClass().getSimpleName();
    private CountDownTimer splashCountDown;
    DisplayMetrics dm;
    int ht;
    int wt;
    public SplashActivity()
    {
    }

    @SuppressLint("NewApi")
	protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.splash);
       // Logger.i(TAG, " ");
        dm = new DisplayMetrics();
        
        ht = dm.heightPixels;
        wt= dm.widthPixels;
       // Logger.d(TAG, (new StringBuilder("height H ")).append(ht).toString());
       // Logger.d(TAG, (new StringBuilder("width W ")).append(wt).toString());
        splashCountDown = new CountDownTimer(Long.parseLong(getResources().getString(R.string.splash_time)), 3000L) {

            public void onFinish()
            {
                Log.d("sreeram", "1111111111111");
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }

            public void onTick(long l)
            {
            }
            
        };
        if (splashCountDown != null)
        {
            splashCountDown.start();
        }
    }
}
