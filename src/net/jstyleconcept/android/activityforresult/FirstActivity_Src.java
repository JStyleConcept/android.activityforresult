package net.jstyleconcept.android.activityforresult;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;

public class FirstActivity_Src extends Activity {
	private WebView sourceCodeView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_first_activity_src);
		sourceCodeView=(WebView)findViewById(R.id.webView1);
		sourceCodeView.getSettings().setBuiltInZoomControls(true);
		sourceCodeView.loadUrl("file:///android_asset/FirstActivity_Src.html");
	}
}