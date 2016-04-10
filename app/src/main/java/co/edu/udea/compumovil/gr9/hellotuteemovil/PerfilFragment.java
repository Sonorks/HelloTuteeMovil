package co.edu.udea.compumovil.gr9.hellotuteemovil;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by JULIAN on 07/04/2016.
 */
public class PerfilFragment extends Fragment {
    dataBaseManager manager;
    Cursor cursor;
    Cursor cursorLogin;
    TextView tvNombreCompleto;
    TextView tvUsuario;
    TextView tvCorreo;
    TextView tvSaldo;
    TextView tvPerfil;
    public PerfilFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.perfil_fragment,
                container, false);
        manager = new dataBaseManager(this.getActivity());
        tvNombreCompleto = (TextView)view.findViewById(R.id.textoPerfilNombreCompleto);
        tvCorreo = (TextView)view.findViewById(R.id.textoPerfilCorreo);
        tvUsuario= (TextView)view.findViewById(R.id.textoPerfilUsername);
        tvSaldo = (TextView)view.findViewById(R.id.textoPerfilSaldo);
        tvPerfil = (TextView)view.findViewById(R.id.textoPerfilPerfil);
        cursorLogin = manager.cargarCursorUsuarioLogeo();
        cursorLogin.moveToFirst();
        String usuario = cursorLogin.getString(0);
        cursor = manager.cargarCursorUsuario(usuario);
        if(cursor.moveToFirst()) {
        tvNombreCompleto.setText(cursor.getString(1));
        tvCorreo.setText(cursor.getString(3));
        tvUsuario.setText(usuario);
        tvSaldo.setText("Null");
        tvPerfil.setText(cursor.getString(5));
        }
        else {
            Toast.makeText(this.getActivity(), "Pailas ma fren", Toast.LENGTH_LONG).show();
        }
        return view;
    }
}
