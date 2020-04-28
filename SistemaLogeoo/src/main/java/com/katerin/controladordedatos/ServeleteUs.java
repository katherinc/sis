package com.katerin.controladordedatos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.katerin.DAO.usuarioDao;

import com.katerin.model.TbUsuariop;

/**
 * Servlet implementation class ServeleteUs
 */
public class ServeleteUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeleteUs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    //doGet(request, response);
		String usu= request.getParameter("nom");
		String contra= request.getParameter("con");
		
		TbUsuariop usuario = new TbUsuariop();
		usuarioDao usudao = new usuarioDao();
		
		usuario.setUsuario(usu);
		usuario.setContrasenia(contra);
		
		
		try {
			int verri = usudao.ingresoUsuario(usuario).size();
			if (verri==1) {
				response.sendRedirect("Principal.jsp");
		     }else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			System.out.println("Error" + e);
	}
		
	}
}


