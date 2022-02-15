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
public class Categoria {
    protected int idCategoria;
    protected String denominacion;

    public Categoria() {
    }

    public Categoria(int idCategoria, String denominacion) {
        this.idCategoria = idCategoria;
        this.denominacion = denominacion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public String toString() {
        return denominacion;
    }
    
    
}
