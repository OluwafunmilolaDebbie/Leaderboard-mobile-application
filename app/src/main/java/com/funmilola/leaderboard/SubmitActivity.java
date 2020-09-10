package com.funmilola.leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SubmitActivity extends AppCompatActivity {
    static EditText firstName;
    static EditText lastName;
    static EditText emailAddress;
    static EditText githubLink;
    String fName, lName, eAddress, gLink;
    Button submitButton;
   Toolbar mToolbar;


    public SubmitActivity() {
    }

    public SubmitActivity(String fName, String lName, String eAddress, String gLink) {
        this.fName = fName;
        this.lName = lName;
        this.eAddress = eAddress;
        this.gLink = gLink;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        emailAddress = findViewById(R.id.email_address);
        githubLink = findViewById(R.id.project_on_github);
        submitButton = findViewById(R.id.submit_button);
        mToolbar = findViewById(R.id.toolbar_submit);




          submitButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {


                  fName = SubmitActivity.firstName.getText().toString();
                  lName = SubmitActivity.lastName.getText().toString();
                  eAddress = SubmitActivity.emailAddress.getText().toString();
                  gLink = SubmitActivity.githubLink.getText().toString();

                  if(TextUtils.isEmpty(fName)){
                      Toast.makeText(SubmitActivity.this, "Please Enter FirstName",Toast.LENGTH_SHORT).show();
                  }
                  else if(TextUtils.isEmpty(lName)){
                      Toast.makeText(SubmitActivity.this, "Please Enter LastName",Toast.LENGTH_SHORT).show();
                  }
                  else if(TextUtils.isEmpty(eAddress)){
                      Toast.makeText(SubmitActivity.this, "Please Enter Address",Toast.LENGTH_SHORT).show();
                  }
                  else if(TextUtils.isEmpty(gLink)){
                      Toast.makeText(SubmitActivity.this, "Please Enter Link",Toast.LENGTH_SHORT).show();
                  }
                  else{
                      Intent intent = new Intent(SubmitActivity.this, NetworkActivity.class);
                      intent.putExtra("fName", fName);
                      intent.putExtra("lName", lName);
                      intent.putExtra("eAddress", eAddress);
                      intent.putExtra("gLink", gLink);
                        startActivity(intent);
                  }

              }
          });

    }

    public void backToMain(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}

