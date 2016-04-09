package co.edu.udea.compumovil.gr9.hellotuteemovil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JULIAN on 07/04/2016.
 */
public class PerfilFragment extends Fragment {
    public PerfilFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.perfil_fragment,
                container, false);

        return view;
    }
}
