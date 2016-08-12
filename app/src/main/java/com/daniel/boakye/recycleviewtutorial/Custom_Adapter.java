package com.daniel.boakye.recycleviewtutorial;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class Custom_Adapter extends RecyclerView.Adapter<Custom_Adapter.ViewHolder> implements View.OnClickListener{
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;
    private int[] mDataSetTypes;

    public static final int BUttonWIthtextView = 1;
    public static final int FloatingWithText = 2;
    public static final int ImageViewer = 0;

    @Override
    public void onClick(View v) {

    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        FloatingActionButton floatbuton;

        public ViewHolder(View v) {
            super(v);

            //  floatbuton = (FloatingActionButton)  v.findViewById(R.id.fabbt);
            //this.score = (TextView) v.findViewById(R.id.score);
            // floatbuton =  (Button) v.findViewById(R.id.fabbt);
            // floatbuton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            // Toast.makeText(v.getContext(),"Book Appointment",Toast.LENGTH_SHORT).show();
         //   Intent i = new Intent(v.getContext(), BookAppointment.class);
          //  v.getContext().  startActivity(i);
        }
    }


    public class WeatherViewHolder extends ViewHolder {
        TextView temp;

        public WeatherViewHolder(View v) {
            super(v);
            // this.temp = (TextView) v.findViewById(R.id.temp);
        }
    }

    public class ButtonWithTextViewHolder extends ViewHolder {
        TextView score;
        Button buton;

        public ButtonWithTextViewHolder(View v) {
            super(v);
            this.score = (TextView) v.findViewById(R.id.score);
            this.buton =  (Button) v.findViewById(R.id.read_more);
            this.buton.setOnClickListener(this);
        }
    }

    public class FloatingButtonwithTextViewHolder extends ViewHolder {
        TextView headline;
        FloatingActionButton floatbuton;

        public FloatingButtonwithTextViewHolder(View v) {
            super(v);
          //  this.headline = (TextView) v.findViewById(R.id.headline);
            this.floatbuton = (FloatingActionButton) v.findViewById(R.id.fabbt);
            this.floatbuton.setOnClickListener(this);
        }
    }

    public class ImageViewHolder extends ViewHolder {
       // TextView headline;
        //Button bookappointment;

        public ImageViewHolder(View v) {
            super(v);
         //   //  this.headline = (TextView) v.findViewById(R.id.headline);
          //  this.bookappointment = (Button) v.findViewById(R.id.read_more);
          //  this.bookappointment.setOnClickListener(this);
        }
    }


    public Custom_Adapter(String[] dataSet, int[] dataSetTypes) {
        mDataSet = dataSet;
        mDataSetTypes = dataSetTypes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == BUttonWIthtextView) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.buttonwithtextview, viewGroup, false);

            return new ButtonWithTextViewHolder(v);

        } else  if (viewType == FloatingWithText) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.floatingbuttonwithtextview, viewGroup, false);
            return new FloatingButtonwithTextViewHolder(v);
        }
        else{
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.imageview, viewGroup, false);
            return new ImageViewHolder(v);

        }

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        if (viewHolder.getItemViewType() == BUttonWIthtextView) {
            ButtonWithTextViewHolder holder = (ButtonWithTextViewHolder) viewHolder;
            // holder.temp.setText(mDataSet[position]);
        } else if (viewHolder.getItemViewType() == FloatingWithText) {
            FloatingButtonwithTextViewHolder holder = ( FloatingButtonwithTextViewHolder ) viewHolder;
            //  holder.headline.setText(mDataSet[position]);
        } else {
           ImageViewHolder holder = (ImageViewHolder) viewHolder;
            // holder.score.setText(mDataSet[position]);



        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSetTypes[position];
    }
}