package forithn.com.formulario_tarea_walter_cruz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

//    private int mYear;
//    private int mMonth;
//    private int mDay;
//
//    private TextView mDateDisplay;
//    private Button mPickDate;
//
//    static final int DATE_DIALOG_ID = 0;

    private TextInputEditText etNombre;
    private DatePicker dpFechaNacimiento;
    private TextInputEditText etTelefono;
    private TextInputEditText etEmail;
    private TextInputEditText etDescripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        dpFechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);
        etTelefono = (TextInputEditText) findViewById(R.id.etTelefono);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etDescripcion = (TextInputEditText) findViewById(R.id.etDescripcion);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            String nombre      = parametros.getString(getResources().getString(R.string.pnombre));
            String fecha       = parametros.getString(getResources().getString(R.string.pfecha));
            String telefono    = parametros.getString(getResources().getString(R.string.ptelefono));
            String email       = parametros.getString(getResources().getString(R.string.pemail));
            String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

            etNombre.setText(nombre);

            String[] separador = fecha.split("/");
            int dia = Integer.parseInt(separador[0]);
            int mes = Integer.parseInt(separador[1]) - 1;
            int anio = Integer.parseInt(separador[2]);
            dpFechaNacimiento.updateDate(anio, mes, dia);

            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
        }



        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString();

                int dia = dpFechaNacimiento.getDayOfMonth();
                int mes = dpFechaNacimiento.getMonth() + 1;
                int anio =  dpFechaNacimiento.getYear();
                String fecha = dia + "/" + mes + "/" + anio;

                String telefono = etTelefono.getText().toString();
                String email = etEmail.getText().toString();
                String descripcion = etDescripcion.getText().toString();


                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);

                intent.putExtra(getResources().getString(R.string.pnombre), nombre);
                intent.putExtra(getResources().getString(R.string.pfecha), fecha);
                intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
                intent.putExtra(getResources().getString(R.string.pemail), email);
                intent.putExtra(getResources().getString(R.string.pdescripcion), descripcion);

                startActivity(intent);

                finish(); //Se finaliza la Actividad
            }
        });


    }

}