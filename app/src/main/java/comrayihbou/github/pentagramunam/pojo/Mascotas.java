package comrayihbou.github.pentagramunam.pojo;


public class Mascotas {

    private String NombreCompleto;
    private int Likes = 0;
    private String UrlFoto;
    private String Id;

    public Mascotas(String UrlFoto, String NombreCompleto, int Likes){
        this.UrlFoto    = UrlFoto;
        this.NombreCompleto     = NombreCompleto;
        this.Likes      = Likes;
    }

    public Mascotas() {
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }

    public String getUrlFoto() {
        return UrlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        UrlFoto = urlFoto;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

}
