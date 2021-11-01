package com.example.reddit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSignUp;
    private Button btnForgotPass;
    private Button btnLogin;
    private final int mainActivityRequest=100;
    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.v("lifecycle","onCreate");
        btnSignUp=(findViewById(R.id.btn_Login));
        username=findViewById(R.id.tb_Username);
        password=findViewById(R.id.tb_Password);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Creeaza-ti un cont",Toast.LENGTH_LONG).show();
                Intent newWindow= new Intent(MainActivity.this,MainActivity2.class);
               // startActivity(newWindow);
                startActivityForResult(newWindow,mainActivityRequest);

            }
        });

        btnLogin=findViewById((R.id.btn_Continue));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Logare cu succes!",Toast.LENGTH_LONG).show();
                Intent newWindow=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(newWindow);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("lifecycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("lifecycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("lifecycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("lifecycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("lifecycle","onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==mainActivityRequest)
        {
            if(resultCode==RESULT_OK)
            {
                if(data!=null)
                {
                    Bundle newBundle=data.getBundleExtra("raspunsBundle");
                    Utilizator u1= (Utilizator) newBundle.getSerializable("User");
                    username.setText(u1.getUsername().toString());
                    password.setText(u1.getPassword().toString());

                }
            }
        }


    }
}