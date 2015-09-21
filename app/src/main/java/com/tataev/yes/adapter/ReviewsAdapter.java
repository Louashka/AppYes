package com.tataev.yes.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tataev.yes.R;
import com.tataev.yes.ReviewsObject;

import java.util.ArrayList;

/**
 * Created by lou on 25.08.2015.
 */
public class ReviewsAdapter extends BaseAdapter {

    private ArrayList<ReviewsObject> adaperList;
    private Context context;
    private TextView[] sizes = new TextView[6];
    private int width = 700;
    private int height = 700;

    private LayoutInflater l_InflaterUA;

    public ReviewsAdapter(Context context, ArrayList<ReviewsObject> adaperList){

        this.context = context;
        this.adaperList = adaperList;
        l_InflaterUA = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return adaperList.size();
    }

    @Override
    public Object getItem(int position) {

        return adaperList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Bitmap bitmap = adaperList.get(position).getObjectImage();
        Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = l_InflaterUA.inflate(R.layout.reviews_adapter, null);
            holder.noveltyImageView = (ImageView)convertView.findViewById(R.id.noveltyImageView);
            holder.typeNovelty = (TextView)convertView.findViewById(R.id.typeNovelty);
            holder.numberNovelty = (TextView)convertView.findViewById(R.id.numberNovelty);
            holder.featuresNovelty = (TextView)convertView.findViewById(R.id.featuresNovelty);
            holder.colorNovelty = (TextView)convertView.findViewById(R.id.colorNovelty);
            holder.sizeXS = (TextView)convertView.findViewById(R.id.sizeXS);
            holder.sizeS = (TextView)convertView.findViewById(R.id.sizeS);
            holder.sizeM = (TextView)convertView.findViewById(R.id.sizeM);
            holder.sizeL = (TextView)convertView.findViewById(R.id.sizeL);
            holder.sizeXL = (TextView)convertView.findViewById(R.id.sizeXL);
            holder.sizeXXL = (TextView)convertView.findViewById(R.id.sizeXXL);
            holder.noveltyPrice = (TextView)convertView.findViewById(R.id.noveltyPrice);
            holder.noveltyRatingBar1 = (RatingBar)convertView.findViewById(R.id.noveltyRatingBar1);
            holder.noveltyRatingBar2 = (RatingBar)convertView.findViewById(R.id.noveltyRatingBar2);
            holder.noveltyRatingBar3 = (RatingBar)convertView.findViewById(R.id.noveltyRatingBar3);
            holder.noveltyRating1 = (TextView)convertView.findViewById(R.id.noveltyRating1);
            holder.noveltyRating2 = (TextView)convertView.findViewById(R.id.noveltyRating2);
            holder.noveltyRating3 = (TextView)convertView.findViewById(R.id.noveltyRating3);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.noveltyImageView.setImageBitmap(newBitmap);
        holder.typeNovelty.setText(adaperList.get(position).getObjectType() + ", " + adaperList.get(position).getObjectCompany());
        holder.numberNovelty.setText("• №" + adaperList.get(position).getObjectNumber().toString());
        if (adaperList.get(position).getObjectFeatures()!=null){
            holder.featuresNovelty.setVisibility(View.VISIBLE);
            String features = "";
            int n = adaperList.get(position).getObjectFeatures().size();
            for (int i = 0; i < n; i++) {
                features += "\u2022 " + adaperList.get(position).getObjectFeatures().get(i) + "\n";
            }
            holder.featuresNovelty.setText(features);
        }
        holder.colorNovelty.setText("Цвет: " + adaperList.get(position).getObjectColor());
        sizes[0] = holder.sizeXS;
        sizes[1] = holder.sizeS;
        sizes[2] = holder.sizeM;
        sizes[3] = holder.sizeL;
        sizes[4] = holder.sizeXL;
        sizes[5] = holder.sizeXXL;
        if (adaperList.get(position).getObjectSize()!=null){
            for (int i = 0; i < adaperList.get(position).getObjectSize().size(); i++) {
                sizes[i].setText(adaperList.get(position).getObjectSize().get(i));
                sizes[i].setVisibility(View.VISIBLE);
            }
        }
        holder.noveltyPrice.setText(adaperList.get(position).getObjectPrice().toString() + " руб.");
        holder.noveltyRatingBar1.setRating((float) adaperList.get(position).getObjectFirstValue() / 100);
        holder.noveltyRatingBar2.setRating((float) adaperList.get(position).getObjectSecondValue() / 100);
        holder.noveltyRatingBar3.setRating((float)adaperList.get(position).getObjectThirdValue() / 100);
        holder.noveltyRating1.setText(adaperList.get(position).getObjectFirstValue() + "%");
        holder.noveltyRating2.setText(adaperList.get(position).getObjectSecondValue() + "%");
        holder.noveltyRating3.setText(adaperList.get(position).getObjectThirdValue() + "%");
        return convertView;
    }

    static class ViewHolder {

        ImageView noveltyImageView;
        TextView typeNovelty;
        TextView numberNovelty;
        TextView featuresNovelty;
        TextView colorNovelty;
        TextView sizeXS;
        TextView sizeS;
        TextView sizeM;
        TextView sizeL;
        TextView sizeXL;
        TextView sizeXXL;
        TextView noveltyPrice;
        RatingBar noveltyRatingBar1;
        RatingBar noveltyRatingBar2;
        RatingBar noveltyRatingBar3;
        TextView noveltyRating1;
        TextView noveltyRating2;
        TextView noveltyRating3;
    }
}
