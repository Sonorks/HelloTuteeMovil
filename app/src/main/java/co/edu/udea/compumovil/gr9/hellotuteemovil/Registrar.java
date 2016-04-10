package co.edu.udea.compumovil.gr9.hellotuteemovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by JULIAN on 22/03/2016.
 */
public class Registrar extends AppCompatActivity implements View.OnClickListener{
    Spinner spinnerPerfil;
    Button botonRegistrar;
    dataBaseManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        final String[] perfil = {"Estudiante","Profesor"};
        botonRegistrar = (Button)findViewById(R.id.botonRegistrar);
        botonRegistrar.setOnClickListener(this);
        manager = new dataBaseManager(this);
        spinnerPerfil = (Spinner) findViewById(R.id.spinnerPerfil);
        spinnerPerfil.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,perfil));
    }
    @Override
    public void onClick(View v){
        registrar();
        Intent i = new Intent(this,Login.class);
        startActivity(i);
        System.exit(0);
    }
    public void registrar(){
        EditText campoNombre = (EditText)findViewById(R.id.NombresRegistrar);
        EditText campoContraseña = (EditText)findViewById(R.id.ContraseñaRegistrar);
        EditText campoCorreo = (EditText)findViewById(R.id.Correo);
        EditText campoUsuario = (EditText)findViewById(R.id.Usuario);
        EditText campoApellido = (EditText) findViewById(R.id.Apellidos);
        String perfil = spinnerPerfil.getSelectedItem().toString();
        String usuario = campoUsuario.getText().toString();
        String nombre = campoNombre.getText().toString();
        String apellido = (campoApellido.getText().toString());
        nombre = nombre.concat(" ");
        nombre = nombre.concat(apellido);
        String contraseña= campoContraseña.getText().toString();
        String correo = campoCorreo.getText().toString();
        manager.insertar(nombre,contraseña,correo,usuario,perfil);
        Toast.makeText(this,"El perfil "+perfil+" ha sido seleccionado",Toast.LENGTH_LONG);
    }
}

