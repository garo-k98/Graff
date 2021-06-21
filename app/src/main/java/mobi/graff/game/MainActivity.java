package mobi.graff.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    private TextView SignUp;
    private TextView ForgotP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        SignUp = (TextView) findViewById(R.id.ClickSignUp);
        ForgotP = (TextView) findViewById(R.id.ClickForgot);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);
            }
        });

        /*ForgotP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, );
                startActivity(intent);
            }
        });*/

        Info.setText("Number of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }
    private void validate(String userName, String userPassword) {
        if((userName.equals("Admin")) && (userPassword.equals("12345"))) {
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("Number of attempts remaining: " + String.valueOf(counter));

            if(counter == 0) {
                Login.setEnabled(false);
            }
        }
    }

}