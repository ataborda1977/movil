package com.example.petagram.pojo;

public class Mascota  {
    String nombreMascota;
    String cantidadLike;
    int imagen;

    public Mascota(String nombreMascota, String cantidadLike, int imagen) {
        this.nombreMascota = nombreMascota;
        this.cantidadLike = cantidadLike;
        this.imagen = imagen;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getCantidadLike() {
        return cantidadLike;
    }

    public void setCantidadLike(String cantidadLike) {
        this.cantidadLike = cantidadLike;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
