package com.mindtree.tables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.mindtree.tables.Employee;
import com.mindtree.tables.FetchData;

/**
 * Servlet implementation class PopulateTable
 */
@WebServlet("/PopulateTable")
public class PopulateTable extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{		
			ArrayList<Employee> country=new ArrayList<Employee>();
			country=FetchData.getAllCountries();

			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(country, new TypeToken<List<Employee>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			System.out.println(jsonArray);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
