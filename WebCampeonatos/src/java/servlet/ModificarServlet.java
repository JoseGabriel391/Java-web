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
@WebServlet(name = "ModificarServlet", urlPatterns = {"/ModificarServlet"})
public class ModificarServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorDB g = new GestorDB();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        ArrayList<Campeonato> lista = g.obtenerListadoCampeonatos();
        request.setAttribute("lista", lista);
        
        
        Equipo equipo = g.obtenerEquipo(id);
        request.setAttribute("equipo", equipo);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editarEquipo.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                GestorDB g = new GestorDB();
                int id = Integer.parseInt((String) request.getParameter("txtId"));
                String nombre = request.getParameter("txtNombre");
                int idCampeonato = Integer.parseInt(request.getParameter("cboCampeonato"));
                int jugadores = Integer.parseInt(request.getParameter("txtJugadores"));
                int cena = Integer.parseInt(request.getParameter("opcion"));
                
                Campeonato c = g.obtenerCampeonato(idCampeonato);
                float importeCena = 0;
                float importeFinal = 0;
                float importe = c.getPrecioEquipo() + (c.getPrecioJugador() * jugadores);
                if (cena == 1) {
                    importeCena = (500 * jugadores) * c.getCantidadFechas();
                }
                importeFinal = importe + importeCena;
                
                g.modificarEquipo(new Equipo(id, nombre, c, jugadores, cena, importeFinal));
                
                request.setAttribute("importeFinal", importeFinal);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/mostrarImporte.jsp");
                rd.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
