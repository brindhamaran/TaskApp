package com.example.user.taskapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MG on 17-07-2016.
 */
public class PayDialogFragment extends BottomSheetDialogFragment {

    String mString,mAmt,comboName,totPayVal;

    static PayDialogFragment newInstance(String string) {
        PayDialogFragment f = new PayDialogFragment();
        Bundle args = new Bundle();
        args.putString("string", string);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mString = getArguments().getString("string");
    }
    public void payAmt(String val,String comboName,String totPayVal){
        this.mAmt = val;
        this.comboName = comboName  ;
        this.totPayVal = totPayVal ;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pay_layout, container, false);
        TextView amtText = (TextView) v.findViewById(R.id.amtText);
        TextView totText = (TextView) v.findViewById(R.id.totText);
        amtText.setText(comboName );
        totText.setText(totPayVal);
        return v;
    }
}
