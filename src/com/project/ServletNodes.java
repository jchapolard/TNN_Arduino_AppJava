package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ServletNodes
 */
@WebServlet("/servletNodes")
//@WebServlet(name = "ServletNodes", urlPatterns = { "/ServletNodes" })
public class ServletNodes extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private int compteur = 0;
	public final static int port = 2345;
	public final static long sleepTime = 5000;

	
	public ServletNodes() {
		super();
	}
    
	/**
	 * Requ�te GET : c'est une requ�te qui permet au client de demander une ressource
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * Requ�te POST : c'est une requ�te qui permet au client d'envoyer des informations issues par exemple d'un formulaire
	 * La m�thode doPost() doit g�n�ralement recueillir les param�tres pour les traiter et g�n�rer la r�ponse
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.mapData(request, response);
	}
	

	/**
	 * Donn�es Client
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void mapData(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ConnexionManager conMng = new ConnexionManager();
		//Map<String, String> options = new HashMap<>();
	    
		// TODO: R�cup�rer les id des nodes pour le client connect�
		Map<String, Object> mapData = conMng.getDataFireBaseAppareil();
		Map<String, String> mapData1 = new HashMap<>();
		Set<Map.Entry<String, Object>> set = mapData.entrySet();
		for (Map.Entry<String, Object> entry : set) {
			// TODO : r�cup�rer les heures totals de chaque node
			mapData1.put(entry.getKey(), String.valueOf(entry.getValue()));
		}
		
	    String json = new Gson().toJson(mapData1);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	    	    	
	}

}
