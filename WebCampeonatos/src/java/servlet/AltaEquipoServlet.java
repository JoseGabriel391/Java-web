/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.GestorDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Campeonato;
import modelo.Equipo;

/**
 *
 * @author jose.romero
 */
@WebServlet(name = "AltaEquipoServlet", urlPatterns = {"/AltaEquipoServlet"})
public class AltaEquipoServlet extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorDB g = new GestorDB();
        ArrayList<Campeonato> lista = g.obtenerListadoCampeonatos();
        request.setAttribute("lista", lista);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaEquipo.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorDB g = new GestorDB();
        
        String nombre = request.getParameter("txtNombre");
        String idCampeonato = request.getParameter("cboCampeonato");
        int cantJugadores = Integer.parseInt(request.getParameter("txtJugadores"));
        int cena = Integer.parseInt(request.getParameter("opcion"));
        
        Campeonato c = g.obtenerCampeonato(Integer.parseInt(idCampeonato));
        float importeCena = 0;
        float importeFinal = 0;
        float importe = c.getPrecioEquipo() + (c.getPrecioJugador() * cantJugadores);
        if (cena==1) {
            importeCena = (500 * cantJugadores) * c.getCantidadFechas();
        }
        importeFinal = importe + importeCena;
        
        Equipo e = new Equipo(nombre, c, cantJugadores, cena, importeFinal);
        g.insertarEquipo(e);
        
        request.setAttribute("importeFinal", importeFinal);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mostrarImporte.jsp");
        rd.forward(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
