package comrayihbou.github.pentagramunam.restApi.Model;

import java.util.ArrayList;

import comrayihbou.github.pentagramunam.pojo.Mascotas;

/**
 * Created by rabihbouorm on 9/19/16.
 */

//Clase necesaria para devolver nuestro arreglo de Mascotas de nuestro web service

public class MascotaResponse {
    ArrayList<Mascotas> mascotas;

    public ArrayList<Mascotas> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascotas> mascotas) {
        this.mascotas = mascotas;
    }
}
