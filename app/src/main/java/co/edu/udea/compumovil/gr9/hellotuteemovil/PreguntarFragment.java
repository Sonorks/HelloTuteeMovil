package co.edu.udea.compumovil.gr9.hellotuteemovil;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by JULIAN on 07/04/2016.
 */
public class PreguntarFragment extends Fragment {
    dataBasePreguntas dbPreguntas;
    dataBaseManager manager;
    Spinner spinnerArea;
    Spinner spinnerAsignatura;
    EditText etTema;
    EditText etPregunta;
    Button botonPreguntar;
    public PreguntarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.preguntar_fragment,
                container, false);
        dbPreguntas = new dataBasePreguntas(this.getActivity());
        manager = new dataBaseManager(this.getActivity());
        spinnerArea = (Spinner)view.findViewById(R.id.SpinnerArea);
        spinnerAsignatura = (Spinner)view.findViewById(R.id.SpinnerAsignatura);
        etTema = (EditText)view.findViewById(R.id.etTema);
        etPregunta = (EditText)view.findViewById(R.id.Pregunta);
        botonPreguntar = (Button) view.findViewById(R.id.botonAñadirPregunta);
        final String[] areas = {"Ingles","Matematicas","Fisicas","Geometria","Programacion"};
        final String[] AsignaturaIngles ={"Ingles 1","Ingles 2","Ingles 3","Ingles 4","Ingles 5","Ingles 6"};
        final String[] AsignaturaMatematicas ={"Calculo Diferencial","Calculo Integral","Calculo Vectorial","Ecuaciones diferenciales"};
        final String[] AsignaturaFisicas ={"Descubriendo la Fisica","Fisica Mecanica","Fisica de Campos","Fisica de Ondas","Termodinamica"};
        final String[] AsignaturaGeometria ={"GeometríaVectorial","Geometria Euclidiana"};
        final String[] AsignaturaProgramacion ={"Logica I","Logica II","Logica III","Teoria de Lenguajes y Compiladores"};
        final Activity  esta = this.getActivity();
        spinnerArea.setAdapter(new ArrayAdapter<String>(esta, android.R.layout.simple_spinner_item, areas));
        spinnerArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    spinnerAsignatura.setAdapter(new ArrayAdapter<String>(esta, android.R.layout.simple_spinner_item, AsignaturaIngles));
                } else if (position == 1) {
                    spinnerAsignatura.setAdapter(new ArrayAdapter<String>(esta, android.R.layout.simple_spinner_item, AsignaturaMatematicas));
                } else if (position == 2) {
                    spinnerAsignatura.setAdapter(new ArrayAdapter<String>(esta, android.R.layout.simple_spinner_item, AsignaturaFisicas));
                } else if (position == 3) {
                    spinnerAsignatura.setAdapter(new ArrayAdapter<String>(esta, android.R.layout.simple_spinner_item, AsignaturaGeometria));
                } else if (position == 4) {
                    spinnerAsignatura.setAdapter(new ArrayAdapter<String>(esta, android.R.layout.simple_spinner_item, AsignaturaProgramacion));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(esta.getBaseContext(), "Selecciona el area para empezar", Toast.LENGTH_LONG);

            }
        });
        botonPreguntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String area = spinnerArea.getSelectedItem().toString();
                String asignatura = spinnerAsignatura.getSelectedItem().toString();
                String tema = etTema.getText().toString();
                Cursor cLogin = manager.cargarCursorUsuarioLogeo();
                cLogin.moveToFirst();
                String username = cLogin.getString(0);
                String pregunta =  etPregunta.getText().toString();
                dbPreguntas.insertar(username,area,asignatura,tema,pregunta,"0");
                System.exit(0);
            }
        });
        return view;
    }
}
