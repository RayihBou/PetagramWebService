package comrayihbou.github.pentagramunam.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import comrayihbou.github.pentagramunam.R;
import comrayihbou.github.pentagramunam.adapter.MiPerroAdaptador;
import comrayihbou.github.pentagramunam.pojo.MiPerro;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {

    ArrayList<MiPerro> miPerros;
    private RecyclerView listaPerros;

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_perfil, container, false);
        listaPerros =(RecyclerView) v.findViewById(R.id.rvMiPerro);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);

        listaPerros.setLayoutManager(glm);
        inicializarPerros();
        inicializarAdaptador();
        return v;
    }*/

    public void inicializarPerros()
    {
        miPerros =    new ArrayList<MiPerro>();
        miPerros.add(new MiPerro(R.drawable.perro,3));
        miPerros.add(new MiPerro(R.drawable.perro,4));
        miPerros.add(new MiPerro(R.drawable.perro,5));
        miPerros.add(new MiPerro(R.drawable.perro,2));
        miPerros.add(new MiPerro(R.drawable.perro,3));
    }

    public MiPerroAdaptador adaptador;
    public void inicializarAdaptador()
    {
        adaptador = new MiPerroAdaptador(miPerros,getActivity());
        listaPerros.setAdapter(adaptador);
    }

}
