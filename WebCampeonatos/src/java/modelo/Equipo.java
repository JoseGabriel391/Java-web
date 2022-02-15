/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jose.romero
 */
public class Equipo {
    protected int id;
    protected String nombre;
    protected Campeonato campeonato;
    protected int jugadores;
    protected int cena;
    protected float importe;

    public Equipo() {
    }

    public Equipo(int id, String nombre, Campeonato campeonato, int jugadores, int cena, float importe) {
        this.id = id;
        this.nombre = nombre;
        this.campeonato = campeonato;
        this.jugadores = jugadores;
        this.cena = cena;
        this.importe = importe;
    }
     public Equipo(String nombre, Campeonato campeonato, int jugadores, int cena, float importe) {
        this.nombre = nombre;
        this.campeonato = campeonato;
        this.jugadores = jugadores;
        this.cena = cena;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nombre=" + nombre + ", campeonato=" + campeonato + ", jugadores=" + jugadores + ", cena=" + cena + ", importe=" + importe + '}';
    }
}
