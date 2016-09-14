package comrayihbou.github.pentagramunam.JavaMail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import comrayihbou.github.pentagramunam.JavaMail.Config;

/**
 * Created by Diego on 8/29/2016.
 */
public class SendMail extends AsyncTask<Void,Void,Void> {

    private Context context;
    private Session session;

    private String correo;
    private String titulo;
    private String mensaje;
    private ProgressDialog progressDialog;

    public SendMail(Context context, String correo, String titulo, String mensaje) {
        //Initializing variables
        this.context = context;
        this.correo = correo;
        this.titulo = titulo;
        this.mensaje = mensaje;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Enviando Mensaje", "Por Favor Espere...", false, false);
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        Toast.makeText(context,"Mensaje Enviado",Toast.LENGTH_LONG).show();
    }


    @Override
    protected Void doInBackground(Void... params) {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Creating a new session
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
                    }
                });

        try {
            //Creating MimeMessage object
            MimeMessage mm = new MimeMessage(session);

            //Setting sender address
            mm.setFrom(new InternetAddress(Config.EMAIL));
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            //Adding subject
            mm.setSubject(titulo);
            //Adding message
            mm.setText(mensaje);

            //Sending email
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}



