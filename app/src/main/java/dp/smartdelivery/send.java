package dp.smartdelivery;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

import static java.security.AccessController.getContext;

public class send extends AppCompatActivity {
    Button sel_loc_send,sel_des_send,details_send,submit_send;
    PlacePicker.IntentBuilder builder;
    final int PLACE_PICKER_REQUEST=1;
    Context context =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sel_loc_send= (Button) findViewById(R.id.sel_loc_send);
        sel_des_send= (Button) findViewById(R.id.sel_des_send);
        details_send= (Button) findViewById(R.id.det_send);
        submit_send= (Button) findViewById(R.id.submit_send);
        builder = new PlacePicker.IntentBuilder();

        sel_des_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    startActivityForResult(builder.build(send.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });


        sel_loc_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    startActivityForResult(builder.build(send.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }

            }
        });

        details_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "det", Toast.LENGTH_SHORT).show();
                detail_input();
            }
        });

        submit_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Request Sent", Toast.LENGTH_SHORT).show();
            }
        });

    }

    void detail_input(){
        AlertDialog.Builder builder = new AlertDialog.Builder(send.this);
        // Get the layout inflater
        LayoutInflater inflater = send.this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.detail_in, null))
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                 builder.create();
                 builder.show();
    }


}
