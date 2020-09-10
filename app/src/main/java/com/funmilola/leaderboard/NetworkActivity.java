package com.funmilola.leaderboard;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkActivity extends AppCompatActivity {
    String fName, lName, eAddress, gLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
             fName = extras.getString("fName");
             lName = extras.getString("lName");
             eAddress = extras.getString("eAddress");
             gLink = extras.getString("gLink");

            final Dialog dialog = new Dialog(NetworkActivity.this);

            dialog.setContentView(R.layout.activity_dialog);

            dialog.setTitle("");

            Button okbtn = dialog.findViewById(R.id.btn_yes);
            ImageView cancelbtn = dialog.findViewById(R.id.image_view);
            dialog.show();
            dialog.getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            // if decline button is clicked, close the custom dialog
            cancelbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    Intent intent = new Intent(NetworkActivity.this, SubmitActivity.class);
                    startActivity(intent);
                    dialog.dismiss();
                }
            });
            okbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(NetworkActivity.this, fName+ "\t"+ lName+ "\t"+ eAddress+ "\t"+ gLink, Toast.LENGTH_SHORT).show();

                    RetrofitEndPointInterface endPointInterface = SubmissionURL.processRetrofitSubmit().create(RetrofitEndPointInterface.class);
                Call<Void> call = endPointInterface.userSubmission(eAddress, fName, lName, gLink);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            showSuccessDialogButtonClicked();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        showFailureDialog();
                    }});
                }
            });
            dialog.closeOptionsMenu();
    }


}
    public void showSuccessDialogButtonClicked(){
        // create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("");
        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.activity_successdialog, null);
        builder.setView(customLayout);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void showFailureDialog(){
        // create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("");
        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.activity_failure, null);
        builder.setView(customLayout);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void backToSubmit(View view) {
        Intent intent = new Intent(getApplicationContext(), SubmitActivity.class);
        startActivity(intent);

    }
}