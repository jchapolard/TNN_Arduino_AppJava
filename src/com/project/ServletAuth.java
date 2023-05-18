package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAuth
 */
@WebServlet(name = "ServletAuth", urlPatterns = { "/servletAuth" })
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuth() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.validationForm(request, response);
	}

	/**
	 * Connexion à la session utilisateur
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void validationForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding( "UTF-8" );
	    PrintWriter out = response.getWriter();  
		
		String identifiant = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		// TODO : Identifiant en bdd
		if (identifiant != null && pwd != null && identifiant.equals("P") && pwd.equals("P")) {
			
			// TODO : Récupération de l'user en bdd
			request.setAttribute( "username", "Pierre" ); // username );
			//this.getServletContext().getRequestDispatcher( "/nodes.html" ).forward( request, response );
			//RequestDispatcher res = request.getRequestDispatcher("/index.html");
            //res.include(request, response);
			RequestDispatcher rd=request.getRequestDispatcher("/nodes.html");
	        rd.forward(request, response);  
	        
		} else {
			// TODO: Mauvais identifiant
			//  Méthode forward() permet depuis une servlet de rediriger la paire requête/réponse HTTP vers une autre servlet ou vers une page JSP
			//this.getServletContext().getRequestDispatcher( "/index.html" ).forward( request, response );
			out.print("Sorry UserName or Password Error!");  
	        RequestDispatcher rd=request.getRequestDispatcher("/authentification.html");  
	        rd.include(request, response);  
		}
		
	}

}
