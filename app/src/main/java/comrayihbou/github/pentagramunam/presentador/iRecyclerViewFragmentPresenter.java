package comrayihbou.github.pentagramunam.presentador;

//El presentador funciona como intermediario entre la base de datos y la interfaz grafica, de tal forma que podamos aislar los metodos y sea mas sencillo el manejo del mismo.

public interface iRecyclerViewFragmentPresenter {

    public void obtenerMascotasBaseDatos();

    public void obtenerMediosRecientes();

    public void mostrarMascotasRV();
}
