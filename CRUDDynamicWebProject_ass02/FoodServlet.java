package com.CAL02Package;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONObject;

/**
 * Servlet implementation class Myservlet
 */
@WebServlet("/Myservlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter ps = response.getWriter();
			response.setHeader("Access-Control-Allow-Origin", "*");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cal02","root","");
//			Insert into table
			int ch = Integer.parseInt(request.getParameter("ch"));
			if(ch == 1) {
				PreparedStatement ps1 = con.prepareStatement("insert into food(name, price, categary) values(?,?,?)");
	//			set the values
				String name = request.getParameter("name");
				float price = Float.parseFloat(request.getParameter("price"));
				String categary = request.getParameter("categary");
				ps1.setString(1, name);
				ps1.setFloat(2, price);
				ps1.setString(3, categary);
				int ic = ps1.executeUpdate();
				if( ic > 0 ) {
					System.out.println("Inserted Successfully");
				}
				else{
					System.out.println("Failed...");
				}
				response.sendRedirect("http://127.0.0.1:5501/index.html");
			}
			else if(ch == 2) {
	//			Display
				PreparedStatement ps2 = con.prepareStatement("select *from food");
				ResultSet r = ps2.executeQuery();
				JSONObject arr = new JSONObject();
				int i = 1;
				while(r.next()) {
					JSONObject ele = new JSONObject();	
					
					ele.put("id", r.getInt("id"));
					ele.put("FoodName", r.getString("name"));
					ele.put("FoodPrice", r.getFloat("price"));
					ele.put("FoodCategary", r.getString("categary"));
					
					arr.put(""+i,ele);
					++i;
				}
				ps.write(arr.toString());
			}
			
			else if(ch == 3) {
	//			Update
				int id = Integer.parseInt(request.getParameter("foodid"));
				String newName = request.getParameter("foodnameNew");
				float nprice = 0;
				nprice = Float.parseFloat(request.getParameter("foodpriceNew"));
				String cat = request.getParameter("foodnewcat");
//				System.out.println(id+""+newName+""+nprice+""+cat);
				
				PreparedStatement ps2 = con.prepareStatement("select *from food where id = ?");
				ps2.setInt(1, id);
				ResultSet r = ps2.executeQuery();
				String n,c;
				float p;
				while(r.next()) {
				n = r.getString("name");
				p = r.getFloat("price");
				c = r.getString("categary");
				
				PreparedStatement ps3 = con.prepareStatement("UPDATE food SET name = ?, price = ?, categary = ? WHERE id = ?" );
				ps3.setString(1, newName.isEmpty() ? n : newName); // If empty, set to previous value present in db
				ps3.setObject(2, nprice == 0 ? p : nprice); // If price is null, keep old price
				ps3.setString(3, cat == null ? c  : cat); // If empty, set null
				ps3.setInt(4, id);
				int uc = ps3.executeUpdate(); 
				if(uc>0) {
					System.out.println("Updated Successfully");
				}
				}
				response.sendRedirect("http://127.0.0.1:5500/index.html");
			}
			
			else if( ch == 4) {
	//			delete
				PreparedStatement ps4 = con.prepareStatement("delete from food where id = ?");
				int delid = Integer.parseInt(request.getParameter("foodIDDel"));
				ps4.setInt(1, delid);
				int dc = ps4.executeUpdate();
				if(dc>0) {
					System.out.println("Deleted Successfully");
				}
				response.sendRedirect("http://127.0.0.1:5500/index.html");
			}
				
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
