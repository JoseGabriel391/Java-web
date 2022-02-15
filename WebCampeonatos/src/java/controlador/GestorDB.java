/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.DtoCategoria;
import dto.DtoListado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Campeonato;
import modelo.Equipo;

/**
 *
 * @author jose.romero
 */
public class GestorDB {
    Connection con;
    String cadena = "jdbc:sqlserver://localhost\\SOPINV-78\\SQLEXPRESS:1433;databaseName=Deportes";
    String user = "sa";
    String pass = "sa123";
    
    public void abrirConexion(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(cadena, user, pass);
            System.out.println("Conexion abieta");
        } catch (Exception e) {
            System.out.println("No se pudo abrir la conexion");
            e.printStackTrace();
        }
    }
    
    public void cerrarConexion(){
        try {
            if(con != null && !con.isClosed()){
                con.close();
            }
            System.out.println("conexion cerrada");
        } catch (Exception e) {
            System.out.println("No se pudo cerrar la conexion");
            e.printStackTrace();
        }
    } 
    
    public ArrayList<Campeonato> obtenerListadoCampeonatos(){
        ArrayList<Campeonato> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            String sql = "select * from campeonatos";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String denominacion = rs.getString("denominacion");
                int idCategoria = rs.getInt("idCategoria");
                float precioEquipo = rs.getFloat("precioEquipo");
                float precioJugador = rs.getFloat("precioJugador");
                int cantidadFechas = rs.getInt("cantidadFechas");
                
                Campeonato c = new Campeonato(id, denominacion, idCategoria, precioEquipo, precioJugador, cantidadFechas);
                lista.add(c);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No obtuvo los campeonatos");
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public Campeonato obtenerCampeonato(int id){
        Campeonato c  = null;
        
        try {
            abrirConexion();
            String sql = "select * from campeonatos where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String denominacion = rs.getString("denominacion");
            int idCategoria = rs.getInt("idCategoria");
            float precioEquipo = rs.getFloat("precioEquipo");
            float precioJugador = rs.getFloat("precioJugador");
            int cantidadFechas = rs.getInt("cantidadFechas");
                
            c = new Campeonato(id, denominacion, idCategoria, precioEquipo, precioJugador, cantidadFechas);

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No obtuvo el campeonato");
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return c;
    }
    
    public boolean insertarEquipo(Equipo e){
        boolean inserto = false;
        
        try {
            abrirConexion();
            String sql = "insert into equipos(nombre, idCampeonato, jugadores, cenas, importe) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setInt(2, e.getCampeonato().getId());
            ps.setInt(3, e.getJugadores());
            ps.setInt(4, e.getCena());
            ps.setFloat(5, e.getImporte());
            
            ps.executeQuery();
            ps.close();
            inserto = true;
            
        } catch (SQLException ex) {
             System.out.println("No obtuvo el campeonato");
            ex.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return inserto;
    }
    
    public float obtenerTotal(){
        float resultado = 0;
        try {
            abrirConexion();
            String sql = "select sum(importe) from equipos";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            resultado = rs.getFloat(1);
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        
        return resultado;
    }
    
    public ArrayList<DtoCategoria> obtenerEquipoPorCategoria(){
        ArrayList<DtoCategoria> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            String sql = "select count(*), c.idCategoria from Equipos e \n" +
                         "  join Campeonatos c on e.idCampeonato = c.id\n" +
                         "  join Categorias cat on c.idCategoria = cat.id\n" +
                         "  group by c.idCategoria;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int cant = rs.getInt(1);
                String nombre = rs.getString(2);
                
                DtoCategoria dc = new DtoCategoria(cant, nombre);
                lista.add(dc);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public ArrayList<DtoListado> obtenerListado(){
        ArrayList<DtoListado> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            String sql = " select e.nombre, e.jugadores, c.denominacion from Equipos e \n" +
                         "  join Campeonatos c on e.idCampeonato = c.id order by c.id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {      
                String equipo = rs.getString(1);
                int cant = rs.getInt(2);
                String denominacion = rs.getString(3);
                
                DtoListado dl = new DtoListado(equipo, cant, denominacion);
                lista.add(dl);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public ArrayList<Equipo> obtenerListadoEquipo(){
        ArrayList<Equipo> lista = new ArrayList<>();
        try {
            abrirConexion();
            String sql = "select * from Equipos;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                int idCampeonato = rs.getInt(3);
                int jugadores = rs.getInt(4);
                int cena = rs.getInt(5);
                float importe = rs.getFloat(6);
                
                Campeonato camp = obtenerCampeonato(idCampeonato);
                
                Equipo e = new Equipo(id, nombre, camp, jugadores, cena, importe);
                lista.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public boolean modificarEquipo(Equipo e){
        boolean modificar = false;
        try {
            abrirConexion();
            String sql = "UPDATE Equipos set nombre=?, idCampeonato=?, jugadores=?, cenas=?, importe=? where id=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setInt(2, e.getCampeonato().getId());
            ps.setInt(3, e.getJugadores());
            ps.setInt(4, e.getCena());
            ps.setFloat(5, e.getImporte());
            ps.setInt(6, e.getId());
            
            ps.executeUpdate();
            ps.close();
            modificar = true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return modificar;
    }
    
    public Equipo obtenerEquipo(int id){
        Equipo e = null;
        try {
            abrirConexion();
            String sql = "select * from Equipos where id=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nombre = rs.getString(2);
                int idCamp = rs.getInt(3);
                int jugadores = rs.getInt(4);
                int cena = rs.getInt(5);
                float importe = rs.getFloat(6);
                
                Campeonato camp = obtenerCampeonato(idCamp);
                e = new Equipo(nombre, camp, jugadores, cena, importe);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return e;
    }
}
