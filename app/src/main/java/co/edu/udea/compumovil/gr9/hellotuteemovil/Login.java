package co.edu.udea.compumovil.gr9.hellotuteemovil;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by JULIAN on 07/04/2016.
 */
public class Login extends AppCompatActivity implements View.OnClickListener{
    dataBaseManager manager;
    private Cursor cursor;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    private EditText user;
    private EditText pass;
    private Button btnLogeo;
    private Button btnRegistro;
    private String[] opciones;
    private DrawerLayout drawerLayout;
    private ListView listView1;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence tituloSec;
    private CharSequence tituloApp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnLogeo =  (Button) findViewById(R.id.botonLogeo);
        btnRegistro = (Button) findViewById(R.id.botonRegistro);
        btnLogeo.setOnClickListener(this);
        btnRegistro.setOnClickListener(this);
        user = (EditText) findViewById(R.id.UsuarioLogin);
        pass= (EditText) findViewById(R.id.ContraseñaLogin);
        manager = new dataBaseManager(this);
        Cursor cLogin = manager.cargarCursorUsuarioLogeo();
        if(cLogin.moveToFirst()){
            logear();
            System.exit(0);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.botonRegistro){
            LanzarRegistrar();
            System.exit(0);
        }
        if(v.getId()==R.id.botonLogeo){
            boolean validar=false;
            validar= manager.buscarUsuarioCursor(user.getText().toString(),pass.getText().toString());
            if(validar) {
                manager.insertarLogeo(user.getText().toString());
                logear();
                System.exit(0);
            }
            else if (validar==false){
                Toast.makeText(this, "Los datos no concuerdan.", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void logear(){
        Intent i = new Intent(this,navigation_activity.class);
        startActivity(i);
    }
    public void LanzarRegistrar(){
        Intent i = new Intent(this,Registrar.class);
        startActivity(i);

    }


}
