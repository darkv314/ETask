package com.example.etask;

import android.os.Parcel;
import android.os.Parcelable;

public class modelTarea implements Parcelable {
    private String titulo;
    private String descripcion;
    private String fechai;

    protected modelTarea(Parcel parcel){
        titulo=parcel.readString();
        descripcion=parcel.readString();
        fechai=parcel.readString();
    }

    public modelTarea(String titulo, String descripcion, String fechai) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.fechai = fechai;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechai() {
        return fechai;
    }

    public void setFechai(String fechai) {
        this.fechai = fechai;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeString(descripcion);
        parcel.writeString(fechai);
    }

    public static final Creator<modelTarea> CREATOR = new Creator<modelTarea>() {
        @Override
        public modelTarea createFromParcel(Parcel parcel) {
            return new modelTarea(parcel);
        }

        @Override
        public modelTarea[] newArray(int i) {
            return new modelTarea[i];
        }
    };
}
