package co.edu.udea.compumovil.gr9.hellotuteemovil;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by JULIAN on 07/04/2016.
 */
public class BuzonFragment extends Fragment {
    ListView listView;
    Adapter adapter;
    Cursor cursor;
    public BuzonFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.buzon_fragment,
                container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        /*manager = new dataBaseCarreras(container.getContext());
        String[] from = new String[]{manager.cn_name,manager.cn_distance,manager.cn_place,manager.cn_date};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};
        cursor = manager.cargarCursorEventos();
        adapter = new SimpleCursorAdapter(view.getContext(),android.R.layout.simple_expandable_list_item_2, cursor, from, to,0);
        listView.setAdapter(adapter); */
        return view;

    }

}
