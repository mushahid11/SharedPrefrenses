package com.eclairiose.sharedprefrenses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String MASSAGES_ID ="Massages pref" ;
    private Button buttonShow;
    private EditText msg_EditText;
    private TextView showMsgTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        msg_EditText = findViewById( R.id.massege_editTextText );
        buttonShow = findViewById( R.id.button_show );
        showMsgTextView = findViewById( R.id.massege_textView );

        buttonShow.setOnClickListener( v -> {
        String massege =    msg_EditText.getText().toString().trim();

        //Mode private means it will be used just by this app, not others app within mobile will use this.
        //Editor is like handle which handle add,remove and some others operations
            SharedPreferences sharedPreferences = getSharedPreferences( MASSAGES_ID,MODE_PRIVATE );
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString( "massage",massege );
            editor.apply();


        } );

        SharedPreferences getSharedData = getSharedPreferences( MASSAGES_ID,MODE_PRIVATE );
        String Data = getSharedData.getString( "massage","Nothing Yet" );
        showMsgTextView.setText( Data );
    }
}