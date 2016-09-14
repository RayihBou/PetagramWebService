package comrayihbou.github.pentagramunam.presentador;

import android.content.Context;

import java.util.ArrayList;

import comrayihbou.github.pentagramunam.DB.ConstructorMascotas;
import comrayihbou.github.pentagramunam.fragment.iRecyclerViewFragmentView;
import comrayihbou.github.pentagramunam.pojo.Mascotas;


public class RecyclerViewFragmentPresenter implements iRecyclerViewFragmentPresenter {

    private iRecyclerViewFragmentView IRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    //Constructor
    public RecyclerViewFragmentPresenter(iRecyclerViewFragmentView IRecyclerViewFragmentView, Context context) {
        this.IRecyclerViewFragmentView=IRecyclerViewFragmentView;
        this.context=context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        //contructor para hacer crear al metodo que estamos importando los datos de la base de datos, realmente se tienen en un constructor
        constructorMascotas = new ConstructorMascotas(context);

        //Obtener datos solicitados del Arraylist
        mascotas = constructorMascotas.obtenerDatos();

        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        IRecyclerViewFragmentView.inicializarAdaptadorRV(IRecyclerViewFragmentView.crearAdaptador(mascotas));
        IRecyclerViewFragmentView.generarLinerLayoutVertical();
    }

}
