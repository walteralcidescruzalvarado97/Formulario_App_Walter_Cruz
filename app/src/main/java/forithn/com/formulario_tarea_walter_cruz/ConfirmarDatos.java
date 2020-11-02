package forithn.com.formulario_tarea_walter_cruz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class ConfirmarDatos extends AppCompatActivity {

    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_confirmar);

        Bundle parametros = getIntent().getExtras();
        nombre       = parametros.getString( getResources().getString(R.string.pnombre) );
        fecha        = parametros.getString( getResources().getString(R.string.pfecha) );
        telefono     = parametros.getString( getResources().getString(R.string.ptelefono) );
        email        = parametros.getString( getResources().getString(R.string.pemail) );
        descripcion  = parametros.getString( getResources().getString(R.string.pdescripcion) );

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvFechaNac = (TextView) findViewById(R.id.tvFechaNac);
        TextView tvTel = (TextView) findViewById(R.id.tvTel);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);


        tvNombre.setText(nombre);
        tvFechaNac.setText(fecha);
        tvTel.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        Button btnEditar = (Button) findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);

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