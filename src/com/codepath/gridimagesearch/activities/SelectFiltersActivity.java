package com.codepath.gridimagesearch.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.codepath.gridimagesearch.R;

public class SelectFiltersActivity extends Activity {
	private Spinner spImgSize;
	private Spinner spImgColor;
	private Spinner spImgType;
	private EditText etSite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_filters);
		spImgSize = (Spinner) findViewById(R.id.spImgSize);
		spImgColor = (Spinner) findViewById(R.id.spImgColor);
		spImgType = (Spinner) findViewById(R.id.spImgType);
		etSite = (EditText) findViewById(R.id.etSite);
		
		String size = getIntent().getStringExtra("size");
		String color = getIntent().getStringExtra("color");
		String type = getIntent().getStringExtra("type");
		String site = getIntent().getStringExtra("site");
		
		setSpinnerToValue(spImgSize, size);
		setSpinnerToValue(spImgColor, color);
		setSpinnerToValue(spImgType, type);
		etSite.setText(site);
	}
	
	public void onSave(View v) {
		String size = spImgSize.getSelectedItem().toString();
		String color = spImgColor.getSelectedItem().toString();
		String type = spImgType.getSelectedItem().toString();
		String site = etSite.getText().toString();
		
		// Pass the expense as a result
		Intent data = new Intent();	
		// Encode data in the intent
		data.putExtra("size", size);
		data.putExtra("color", color);
		data.putExtra("type", type);
		data.putExtra("site", site);
		setResult(RESULT_OK, data);
		
		// Remove this item from the stack and take to the previous activity
		finish();		
	}
	
	private void setSpinnerToValue(Spinner spinner, String value) {
		if (value == null || value.isEmpty()) {
			return; // No selection was made
		}
		
		int index = 0;
		SpinnerAdapter adapter = spinner.getAdapter();
		for (int i = 0; i < adapter.getCount(); i++) {
			if (adapter.getItem(i).equals(value)) {
				index = i;
				break; // terminate loop
			}
		}
		spinner.setSelection(index);
	}
}
