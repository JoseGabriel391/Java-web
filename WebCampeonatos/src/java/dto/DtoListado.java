/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author jose.romero
 */
public class DtoListado {
    protected String nombreEquipo;
    protected int cantJugadores;
    protected String nombreCampeonato;

    public DtoListado() {
    }

    public DtoListado(String nombreEquipo, int cantJugadores, String nombreCampeonato) {
        this.nombreEquipo = nombreEquipo;
        this.cantJugadores = cantJugadores;
        this.nombreCampeonato = nombreCampeonato;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public String getNombreCampeonato() {
        return nombreCampeonato;
    }

    public void setNombreCampeonato(String nombreCampeonato) {
        this.nombreCampeonato = nombreCampeonato;
    }

    @Override
    public String toString() {
        return "DtoListado{" + "nombreEquipo=" + nombreEquipo + ", cantJugadores=" + cantJugadores + ", nombreCampeonato=" + nombreCampeonato + '}';
    }
    
    
}
