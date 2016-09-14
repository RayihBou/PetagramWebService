package comrayihbou.github.pentagramunam.pojo;


public class Mascotas {

    private String Nombre;
    private int Likes;
    private int Foto;
    private int Id;

    public Mascotas(int Foto, String Nombre, int Likes){
        this.Foto       = Foto;
        this.Nombre     = Nombre;
        this.Likes      = Likes;
    }

    public Mascotas() {

    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }



}
