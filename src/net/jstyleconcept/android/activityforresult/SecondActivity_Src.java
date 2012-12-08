package net.jstyleconcept.android.activityforresult;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;

public class SecondActivity_Src extends Activity {
	WebView sourceCodeView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second_activity_src);
		sourceCodeView=(WebView)findViewById(R.id.webView1);
		sourceCodeView.getSettings().setBuiltInZoomControls(true);
		sourceCodeView.loadUrl("file:///android_asset/SecondActivity_Src.html");
	}
}