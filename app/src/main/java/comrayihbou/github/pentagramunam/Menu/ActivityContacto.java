package comrayihbou.github.pentagramunam.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import comrayihbou.github.pentagramunam.JavaMail.SendMail;
import comrayihbou.github.pentagramunam.R;

public class ActivityContacto extends AppCompatActivity implements View.OnClickListener {


    //Datos Javamail

    private EditText etCorreo;
    private EditText etTitulo;
    private EditText etMensaje;
    private Button btnsend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_contacto);

        //JavaMail*****************************

        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etTitulo = (EditText) findViewById(R.id.ettitulo);
        etMensaje = (EditText) findViewById(R.id.etMensaje);

        btnsend = (Button) findViewById(R.id.btnsend);

        btnsend.setOnClickListener(this);
    }

    private void sendEmail() {
        //Getting content for email
        String correo = etCorreo.getText().toString().trim();
        String titulo = etTitulo.getText().toString().trim();
        String mensaje = etMensaje.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, correo, titulo, mensaje);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}

