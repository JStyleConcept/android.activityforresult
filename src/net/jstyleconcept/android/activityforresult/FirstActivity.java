package net.jstyleconcept.android.activityforresult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends Activity {
	private EditText edit1,edit2;
	private Button sendButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_firstactivity);
		edit1=(EditText)findViewById(R.id.editText1);
		edit2=(EditText)findViewById(R.id.editText2);
		sendButton=(Button)findViewById(R.id.button1);
		sendButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
				Bundle bundle=new Bundle();
				bundle.putString("value1",edit1.getText().toString());
				bundle.putString("value2",edit2.getText().toString());
				intent.putExtras(bundle);
				startActivityForResult(intent,0);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data) {
		switch(resultCode) {
		case RESULT_OK:
			Bundle bundle=data.getExtras();
			edit1.setText(bundle.getString("value1"));
			edit2.setText(bundle.getString("value2"));
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.layout_firstactivity,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent=new Intent(FirstActivity.this,FirstActivity_Src.class);
		switch(item.getOrder()) {
		case 0:
			startActivity(intent);
			break;
		case 1:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}