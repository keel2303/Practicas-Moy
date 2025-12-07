package com.example.pasardatosjava;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {

    private String nombre;
    private int edad;
    private boolean estudiante;

    public Persona(String nombre, int edad, boolean estudiante) {
        this.nombre = nombre;
        this.edad = edad;
        this.estudiante = estudiante;
    }

    protected Persona(Parcel in) {
        nombre = in.readString();
        edad = in.readInt();
        estudiante = in.readByte() != 0;
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isEstudiante() {
        return estudiante;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(edad);
        dest.writeByte((byte) (estudiante ? 1 : 0));
    }
}
