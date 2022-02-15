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
public class Campeonato {
    protected int id;
    protected String denominacion;
    protected int idCategoria;
    protected float precioEquipo;
    protected float precioJugador;
    protected int cantidadFechas;

    public Campeonato() {
    }

    public Campeonato(int id, String denominacion, int idCategoria, float precioEquipo, float precioJugador, int cantidadFechas) {
        this.id = id;
        this.denominacion = denominacion;
        this.idCategoria = idCategoria;
        this.precioEquipo = precioEquipo;
        this.precioJugador = precioJugador;
        this.cantidadFechas = cantidadFechas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public float getPrecioEquipo() {
        return precioEquipo;
    }

    public void setPrecioEquipo(float precioEquipo) {
        this.precioEquipo = precioEquipo;
    }

    public float getPrecioJugador() {
        return precioJugador;
    }

    public void setPrecioJugador(float precioJugador) {
        this.precioJugador = precioJugador;
    }

    public int getCantidadFechas() {
        return cantidadFechas;
    }

    public void setCantidadFechas(int cantidadFechas) {
        this.cantidadFechas = cantidadFechas;
    }

    @Override
    public String toString() {
        return denominacion;
    }
    
    
    
}
