package net.jstyleconcept.android.activityforresult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
	private TextView resultText1,resultText2;
	private Button backButton;
	private Intent intent;
	private Bundle bundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_secondactivity);
		intent=getIntent();
		bundle=intent.getExtras();
		resultText1=(TextView)findViewById(R.id.editText1);
		resultText2=(TextView)findViewById(R.id.editText2);
		backButton=(Button)findViewById(R.id.button1);
		backButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				bundle.putString("value1",resultText1.getText().toString());
				bundle.putString("value2",resultText2.getText().toString());
				intent.putExtras(bundle);
				SecondActivity.this.setResult(RESULT_OK,intent);
				SecondActivity.this.finish();
			}
		});
		resultText1.setText(bundle.getString("value1"));
		resultText2.setText(bundle.getString("value2"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.layout_secondactivity,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent=new Intent(SecondActivity.this,SecondActivity_Src.class);
		switch(item.getOrder()) {
			case 0:
				startActivity(intent);
				break;
			case 1:
				Intent intentInit=new Intent(SecondActivity.this,FirstActivity.class);
				intentInit.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentInit);
				moveTaskToBack(true);
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}