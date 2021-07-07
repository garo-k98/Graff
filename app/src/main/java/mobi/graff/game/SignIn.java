package mobi.graff.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    private EditText Email;
    private EditText UserName;
    private EditText Password;
    private EditText Password2;
    private Button Submit;
    private TextView HaveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Email = (EditText) findViewById(R.id.etEmail);
        UserName = (EditText) findViewById(R.id.etNameEnter);
        Password = (EditText) findViewById(R.id.etPasswordEnter);
        Password2 = (EditText) findViewById(R.id.etPasswordEnter2);
        Submit = (Button) findViewById(R.id.btnSubmit);
        HaveAccount = (TextView) findViewById(R.id.ClickHaveAccount);

        HaveAccount.setOnClickListener(v -> {
            Intent intent = new Intent(SignIn.this, MainActivity.class);
            startActivity(intent);
        });
    }
}