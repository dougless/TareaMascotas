package com.mascotas.pojo;

/**
 * Created by DESARROLLO2 on 7/06/2016.
 */
public class Foto {
    private int likes;
    private int foto;

    public Foto(int likes, int foto) {
        this.likes = likes;
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {

        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
