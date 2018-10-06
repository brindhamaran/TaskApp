package com.example.user.taskapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ComboPagerAdapter extends PagerAdapter {
    Context context;
    int images[];
    int comboStyle = 0;
    int totVal  ;
    LayoutInflater layoutInflater;


    public ComboPagerAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.items_layout, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        ImageView plusImage = (ImageView) itemView.findViewById(R.id.plusImage);
        ImageView minusImage = (ImageView) itemView.findViewById(R.id.minusImage);
        final Button normalBtn = (Button) itemView.findViewById(R.id.normalBtn);
        final Button regularBtn = (Button) itemView.findViewById(R.id.regularBtn);
        final Button largeBtn = (Button) itemView.findViewById(R.id.largeBtn);
        final TextView amtText = (TextView) itemView.findViewById(R.id.amtText);
        final TextView comboName = (TextView) itemView.findViewById(R.id.comboName);
        final Button payBtn = (Button) itemView.findViewById(R.id.payBtn);
        final Button inrBtn = (Button) itemView.findViewById(R.id.inrBtn);
        final PayDialogFragment payDialogFragment = PayDialogFragment.newInstance("Modal Bottom Sheet");

        normalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                normalBtn.setBackgroundColor(Color.YELLOW);
                regularBtn.setBackgroundColor(Color.TRANSPARENT);
                largeBtn.setBackgroundColor(Color.TRANSPARENT);
                regularBtn.setBackgroundResource(R.drawable.itemsbutton_shape);
                largeBtn.setBackgroundResource(R.drawable.itemsbutton_shape);
                comboStyle = 0 ;
            }
        });

        regularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regularBtn.setBackgroundColor(Color.YELLOW);
                normalBtn.setBackgroundColor(Color.TRANSPARENT);
                largeBtn.setBackgroundColor(Color.TRANSPARENT);
                normalBtn.setBackgroundResource(R.drawable.itemsbutton_shape);
                largeBtn.setBackgroundResource(R.drawable.itemsbutton_shape);
                comboStyle = 1;
                comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(200));
            }
        });

        largeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                largeBtn.setBackgroundColor(Color.YELLOW);
                regularBtn.setBackgroundColor(Color.TRANSPARENT);
                normalBtn.setBackgroundColor(Color.TRANSPARENT);
                regularBtn.setBackgroundResource(R.drawable.itemsbutton_shape);
                normalBtn.setBackgroundResource(R.drawable.itemsbutton_shape);
                comboStyle = 2 ;
                comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(500));
            }
        });

        comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(100));
        inrBtn.setText("INR "+ String.valueOf(100));
        plusImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                totVal = Integer.parseInt(amtText.getText().toString());
                int totamt = totVal + 1;
                amtText.setText(String.valueOf(totamt));
                if(comboStyle == 1){
                    int amt = totamt * 200;
                    comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(amt));
                    inrBtn.setText("INR "+ String.valueOf(amt));
                }else if(comboStyle == 2){

                    int amt = totamt * 500;

                    comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(amt));
                    inrBtn.setText("INR "+ String.valueOf(amt));

                }else {

                    int amt = totamt * 100;
                    comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(amt));
                    inrBtn.setText("INR "+ String.valueOf(amt));

                }

            }
        });

        minusImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totVal = Integer.parseInt(amtText.getText().toString());
                int totamt = totVal - 1;
                if(comboStyle == 1){

                    if (totamt < 0) {
                        amtText.setText(String.valueOf(00));
                        comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(100));
                        inrBtn.setText("INR "+ String.valueOf(100));
                    }else{
                        amtText.setText(String.valueOf(totamt));
                        int amt = totamt * 200;
                        comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(amt));
                        inrBtn.setText("INR "+ String.valueOf(amt));
                    }
                }else if(comboStyle == 2){

                    if (totamt < 0) {
                        amtText.setText(String.valueOf(00));
                        comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(100));
                        inrBtn.setText("INR "+ String.valueOf(100));
                    }else{
                        amtText.setText(String.valueOf(totamt));
                        int amt = totamt * 500;
                        comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(amt));
                        inrBtn.setText("INR "+ String.valueOf(amt));
                    }
                }else {
                    if (totamt < 0) {
                        amtText.setText(String.valueOf(00));
                        comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(100));
                        inrBtn.setText("INR "+ String.valueOf(100));
                    }else{
                        amtText.setText(String.valueOf(totamt));
                        int amt = totamt * 100;
                        comboName.setText("BURGER WITH CHIPS " +System.lineSeparator() +" INR "+ String.valueOf(amt));
                        inrBtn.setText("INR "+ String.valueOf(amt));
                    }


                }

            }
        });

        payBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                payDialogFragment.show( ((AppCompatActivity) context).getSupportFragmentManager(),payDialogFragment.getTag());
            }
        });

        inrBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                payDialogFragment.payAmt(inrBtn.getText().toString(),"BURGER WITH CHIPS");
                payDialogFragment.show( ((AppCompatActivity) context).getSupportFragmentManager(),payDialogFragment.getTag());
            }
        });

        imageView.setImageResource(images[position]);

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}