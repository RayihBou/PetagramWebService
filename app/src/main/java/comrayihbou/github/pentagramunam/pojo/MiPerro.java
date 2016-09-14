package comrayihbou.github.pentagramunam.pojo;

/**
 * Created by Diego on 8/31/2016.
 */
public class MiPerro {
    int Foto;
    int Likes;

    public MiPerro(int foto, int likes) {
        Foto = foto;
        Likes = likes;
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

    public String Likes()
    {
        return Integer.toString(Likes);
    }
}
