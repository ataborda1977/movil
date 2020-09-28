package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class ConfirmarDatos extends AppCompatActivity {
    Button btnEditar;
    String nombreCompleto ;
    String telefono ;
    String email ;
    String descripcion ;
    String fechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        nombreCompleto = parametros.getString("NombreCompleto");
        telefono = parametros.getString("Telefono");
        email = parametros.getString("Email");
        descripcion = parametros.getString("Descripcion");
        fechaNacimiento = parametros.getString("FechaNacimiento");

        TextView tvNombre =(TextView)  findViewById(R.id.txtvNombreCompleto);
        TextView tvTelefono =(TextView)  findViewById(R.id.txtvTelefono);
        TextView tvEmail =(TextView)  findViewById(R.id.txtvEmail);
        TextView tvDescripcion =(TextView)  findViewById(R.id.txtvDescripcion);
        TextView tvFechaNacimiento =(TextView)  findViewById(R.id.txtvFechaNacimiento);
        Button btnEditar =(Button)  findViewById(R.id.BotonEditar);

        tvNombre.setText(nombreCompleto);
        tvTelefono.setText(telefono);
        tvDescripcion.setText(descripcion);
        tvEmail.setText(email);
        tvFechaNacimiento.setText(fechaNacimiento);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacto contacto = new Contacto(nombreCompleto,fechaNacimiento, telefono,email,descripcion);

                Intent intent = new Intent (ConfirmarDatos.this, MainActivity.class);
                intent.putExtra("NombreCompletoE",contacto.getNombre());
                intent.putExtra("TelefonoE",contacto.getTelefono());
                intent.putExtra("EmailE",contacto.getEmail());
                intent.putExtra("DescripcionE",contacto.getNombre());
                intent.putExtra("FechaNacimientoE",contacto.getFechaNacimiento());
                startActivity(intent);

            }
        });

    }
}