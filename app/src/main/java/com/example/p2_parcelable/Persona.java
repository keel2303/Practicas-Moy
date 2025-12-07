package com.example.p2_parcelable;

import android.os.Parcel;
import android.os.Parcelable;
public class Persona implements Parcelable {
    private String nombre;
    private int edad;
    private boolean soltero;

    public Persona(String nombre, int edad, boolean soltero){
        this.nombre = nombre;
        this.edad = edad;
        this.soltero = soltero;
    }
    protected Persona(Parcel in){
        nombre = in.readString();
        edad = in.readInt();
        soltero = in.readByte() !=0;
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
    @Override
    public int describeContents(){ return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(nombre);
        dest.writeInt(edad);
        dest.writeByte((byte)(soltero ? 1 : 0));
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isSoltero() {
        return soltero;
    }
}
