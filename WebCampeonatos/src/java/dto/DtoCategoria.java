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
public class DtoCategoria {
    protected int cant;
    protected String denominacion;

    public DtoCategoria() {
    }

    public DtoCategoria(int cant, String denominacion) {
        this.cant = cant;
        this.denominacion = denominacion;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    } 

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    
    @Override
    public String toString() {
        return "DtoCategoria{" + "cant=" + cant + ", denominacion=" + denominacion + '}';
    }
    
    
}
