package com.codepath.gridimagesearch.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.gridimagesearch.R;
import com.codepath.gridimagesearch.helpers.GenericAdapter;
import com.codepath.gridimagesearch.models.ImageResult;
import com.squareup.picasso.Picasso;

public class ImageResultsGenericAdapter extends GenericAdapter<ImageResult> {
	Context context;
	public ImageResultsGenericAdapter(Activity activity, Context context, List<ImageResult> list) {
		super(activity, list);
		this.context = context;
	}

	private static class ViewHolder {
		ImageView ivImage;
		TextView tvTitle;
	}

	@Override
	public View getDataRow(int position, View convertView, ViewGroup parent) {
		// Get the data item for this position
		ImageResult imageResult = getItem(position);
		
		ViewHolder viewHolder; // View lookup cache
		// Check if an existing view is being reused, otherwise inflate the view
		if (convertView == null) {
			convertView = LayoutInflater.from(this.context).inflate(
					R.layout.item_image_result, parent, false);
			viewHolder = new ViewHolder();
			// Lookup view for data population
			viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
			viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		// Clear out image from last time as this could be a recycled view
		viewHolder.ivImage.setImageResource(0);
		Picasso.with(this.context).load(imageResult.thumbUrl).into(viewHolder.ivImage);

		// Populate the title
		viewHolder.tvTitle.setText(Html.fromHtml(imageResult.title));

		// Return the completed view to render on screen
		return convertView;
	}
}
