package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class ActivityContacto extends AppCompatActivity {

    Button botonEnviar;
    EditText nombreEdit;
    EditText correoEdit;
    EditText mensajeEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        botonEnviar = (Button) findViewById(R.id.btnEnviar);
        nombreEdit = (EditText) findViewById(R.id.nombreEdit);
        correoEdit = (EditText) findViewById(R.id.correoEdit);
        mensajeEdit = (EditText) findViewById(R.id.mensajeEdit);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String nombre = nombreEdit.getText().toString().trim();
                    String correo= correoEdit.getText().toString().trim();
                    String mensaje = mensajeEdit.getText().toString().trim();
                    String host="smtp.gmail.com";


                    Toast.makeText(ActivityContacto.this,"Inicio Envio Correo",Toast.LENGTH_LONG).show();


                StrictMode.ThreadPolicy policy = new  StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);


                Properties props = new Properties();
                   props.put("mail.smtp.host",host);
                     props.put("mail.smtp.auth", "true");

                     Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication("cuenta@gmail.com","clave");
                            }
                        });




                    //crear el mensaje
                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("cuenta@gmail.com"));
                    message.addRecipient(Message.RecipientType.TO,new InternetAddress(correo));
                    message.setSubject("Contacto Desde App Mascotas Android");
                    message.setText(mensaje);

                    Transport transport = session.getTransport("smtp");
                    transport.connect("smtp.gmail.com", "cuenta@gmail.com", "clave");

                    //transport.send(message);
                    transport.sendMessage(message,message.getAllRecipients());
                    transport.close();
                    Transport.send(message);


                    //Enviar Correo
                    Toast.makeText(ActivityContacto.this,"Mensaje Enviado",Toast.LENGTH_LONG).show();






                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }

/*

            //enviar correo
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , correo);
                i.putExtra(Intent.EXTRA_SUBJECT, nombre);
                i.putExtra(Intent.EXTRA_TEXT   , mensaje);
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ActivityContacto.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }


            }*/
        });


    }
}
