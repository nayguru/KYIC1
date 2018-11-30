// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.celab.kyic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//import com.science6.util.Logger;

//import com.science6.BaseActivity;
//import com.science6.VideoPlayerActivity;

public class HomeActivity extends Activity
{

	  protected void onCreate(Bundle bundle)
	    {
	        super.onCreate(bundle);
	        //Logger.e(TAG, "qqqqqqqqqqqqqq");
			Log.e("Sreeram", "werewrewrewr" );
	        setContentView(R.layout.home);
	        
	        WebView myWebView = (WebView) findViewById(R.id.webview);
	        myWebView.loadUrl("http://www.kyic.in/kyic/login.php");

	        WebSettings webSettings = myWebView.getSettings();
	        webSettings.setJavaScriptEnabled(true);
	        
	        myWebView.setWebViewClient(new WebViewClient());

	                  
	    }

	@Override
	public void onBackPressed() {
		WebView myWebView = (WebView) findViewById(R.id.webview);
		Log.d("kyic",myWebView.getUrl());
		if (myWebView.canGoBack()) {
			myWebView.goBack();
		}else {

			new AlertDialog.Builder(this)
					.setTitle("Want to exit?")
					.setMessage("Are you sure you want to exit?")
					.setNegativeButton(android.R.string.no, null)
					.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface arg0, int arg1) {
							HomeActivity.super.onBackPressed();
						}
					}).create().show();
		}
	}


	    
	  private class MyWebViewClient extends WebViewClient {
		    @Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		        if (Uri.parse(url).getHost().equals("www.google.com")) {
		            // This is my web site, so do not override; let my WebView load the page
		            return false;
		        }
		        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
		        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		        startActivity(intent);
		        return true;
		    }
		}
 

}
