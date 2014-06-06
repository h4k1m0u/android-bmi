package org.h4k1m.imcandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText heightEdit;
	private EditText weightEdit;
	private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// set layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // get height & weight widgets
        heightEdit = (EditText) findViewById(R.id.height);
        weightEdit = (EditText) findViewById(R.id.weight);
        button = (Button) findViewById(R.id.button);
        
        // on button click, calculate bmi
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float height = Float.parseFloat(heightEdit.getText().toString());
				int weight = Integer.parseInt(weightEdit.getText().toString());
				int bmi = (int) (weight / (height * height));
				
				// change the message according to the bmi
				String message = "";
				if (bmi < 20)
					message = getResources().getString(R.string.skinny);
				else if (bmi >=20 && bmi < 30)
					message = getResources().getString(R.string.normal);
				else
					message = getResources().getString(R.string.fat);
				
				// print the bmi on a toast
				Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
			}
		});
    }
}
