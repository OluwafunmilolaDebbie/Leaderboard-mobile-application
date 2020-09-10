package com.funmilola.leaderboard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccessactivityDialog extends Dialog {
    public Activity c;
    ImageView sImg;
    TextView sTxt;
    Dialog d;

    public SuccessactivityDialog(Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_successdialog);
        sImg = findViewById(R.id.success);
        sTxt = findViewById(R.id.success_text);
    }
}