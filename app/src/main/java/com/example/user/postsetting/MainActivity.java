package com.example.user.postsetting;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    final Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        // add button listener
        fab.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.post_setting);


                Button dialogButton = (Button) dialog.findViewById(R.id.btn_post);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                //button for anonymous
                final Button btn_anonymous = (Button) dialog.findViewById(R.id.btn_anonymous);
                btn_anonymous.setBackgroundResource(R.mipmap.anonymous);
                dialogButton.setOnClickListener(new OnClickListener() {

                    boolean select = false;


                    @Override
                    public void onClick(View v) {


                       if (select != true) {
                            select = true;
                            btn_anonymous.setBackgroundResource(R.mipmap.annonymous2_grey);
                        } else if (select != false) {
                            select = false;
                            btn_anonymous.setBackgroundResource(R.mipmap.annonymous2_green);
                        }
                    }
                });



                dialog.show();
            }

        });

        /*final Spinner spin = (Spinner) findViewById((R.id.map_places));
        final String spinVal = String.valueOf(spin.getSelectedItem());*/




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
