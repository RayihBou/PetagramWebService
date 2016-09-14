package comrayihbou.github.pentagramunam.fragment;

import java.util.ArrayList;

import comrayihbou.github.pentagramunam.adapter.MascotasAdaptador;
import comrayihbou.github.pentagramunam.pojo.Mascotas;

//La interfaz se utiliza para hacer mas amigable la vista al codigo de tal forma que sea mas facil de leer, funciona como un pojo para mantener aislados los datos ingresados
//Se ingresas todos los metodos utilizados para el adaptador presentador

public interface iRecyclerViewFragmentView {

    public void generarLinerLayoutVertical();

    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV(MascotasAdaptador adaptador);
}
