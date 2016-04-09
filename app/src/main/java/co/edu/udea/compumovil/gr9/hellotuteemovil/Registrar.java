package co.edu.udea.compumovil.gr9.hellotuteemovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by JULIAN on 22/03/2016.
 */
public class Registrar extends AppCompatActivity implements View.OnClickListener{
    Button botonRegistrar;
    dataBaseManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        botonRegistrar = (Button)findViewById(R.id.botonRegistrar);
        botonRegistrar.setOnClickListener(this);
        manager = new dataBaseManager(this);
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
        String perfil = "Estudiante";
        String usuario = campoUsuario.getText().toString();
        String nombre = campoNombre.getText().toString();
        String contraseña= campoContraseña.getText().toString();
        String correo = campoCorreo.getText().toString();
        manager.insertar(nombre,contraseña,correo,usuario,perfil);
    }
}

