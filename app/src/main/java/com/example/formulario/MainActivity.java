package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {

    Button mButton;
    TextView mTextView;
    Button mButtonSiguiente;
    TextInputEditText mTextInputEditTextNombre;
    TextView mTextViewFechaNacimiento;
    TextInputEditText mTextInputEditTextTelefono;
    TextInputEditText mTextInputEditTextEmail;
    TextInputEditText mTextInputEditTextDescripcion;

    String nombreCompletoEdicion;
    String telefonoEdicion;
    String emailEdicion;
    String descripcionEdicion;
    String fechaNacimientoEdicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton =(Button) findViewById(R.id.btnFechaNacimiento);
        mTextView = (TextView) findViewById(R.id.txtvFechaNacimiento);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();
        final long today = MaterialDatePicker.todayInUtcMilliseconds();
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Fecha Nacimiento");
        builder.setSelection(today);
        final MaterialDatePicker materialDatePicker = builder.build();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(),"DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                String inputFormat = "dd MMM yyyy";
                String outputFormat = "dd/MM/yyyy";

                String inputDate = materialDatePicker.getHeaderText();
                String outputDate = inputDate;
                try {
                outputDate = new SimpleDateFormat(outputFormat, Locale.US).format(new SimpleDateFormat(inputFormat, Locale.US).parse(inputDate));
                } catch (Exception e) {
                    System.out.println("formateDateFromstring(): " + e.getMessage());
                    outputDate = "";
                }
                //mTextView.setText(outputDate);
               mTextView.setText(materialDatePicker.getHeaderText());

            }
        });

        //Boton Siguiente ir a Pantalla ConfirmarDatos
        mButtonSiguiente = (Button) findViewById(R.id.BtnSiguiente);
        mTextInputEditTextNombre =(TextInputEditText) findViewById(R.id.txtNombre);
        mTextInputEditTextTelefono  =(TextInputEditText) findViewById(R.id.txtTelefono);
        mTextInputEditTextEmail =(TextInputEditText) findViewById(R.id.txtEmail);
        mTextInputEditTextDescripcion=(TextInputEditText) findViewById(R.id.txtDescripcion);


        mButtonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Contacto contacto = new Contacto(mTextInputEditTextNombre.getText().toString(),
                                    mTextView.getText().toString(),
                                    mTextInputEditTextTelefono.getText().toString(),
                                    mTextInputEditTextEmail.getText().toString(),
                                    mTextInputEditTextDescripcion.getText().toString()
                );

                Intent intent = new Intent (MainActivity.this, ConfirmarDatos.class);
                //capturar las varianles para enviarlas a la otra actividad confirmar datos
                intent.putExtra("NombreCompleto",contacto.getNombre());
                intent.putExtra("FechaNacimiento",contacto.getFechaNacimiento().toString());
                intent.putExtra("Telefono",contacto.getTelefono());
                intent.putExtra("Email",contacto.getEmail());
                intent.putExtra("Descripcion",contacto.getDescripcion());


                startActivity(intent);
            }
        });

        //recibir Datos Pantalla Edicion
        Bundle parametros = getIntent().getExtras();
        if (parametros!=null) {
            nombreCompletoEdicion = parametros.getString("NombreCompletoE");
            telefonoEdicion = parametros.getString("TelefonoE");
            emailEdicion = parametros.getString("EmailE");
            descripcionEdicion = parametros.getString("DescripcionE");
            fechaNacimientoEdicion = parametros.getString("FechaNacimientoE");

            mTextInputEditTextNombre=(TextInputEditText) findViewById(R.id.txtNombre);
            mTextInputEditTextTelefono=(TextInputEditText) findViewById(R.id.txtTelefono);
            mTextInputEditTextEmail=(TextInputEditText) findViewById(R.id.txtEmail);
            mTextInputEditTextDescripcion=(TextInputEditText) findViewById(R.id.txtDescripcion);
            mTextViewFechaNacimiento=(TextView) findViewById(R.id.txtvFechaNacimiento);

            mTextInputEditTextNombre.setText(nombreCompletoEdicion);
            mTextInputEditTextTelefono.setText(telefonoEdicion);
            mTextInputEditTextEmail.setText(emailEdicion);
            mTextInputEditTextDescripcion.setText(descripcionEdicion);
            mTextViewFechaNacimiento.setText(fechaNacimientoEdicion);

        }
    }
}