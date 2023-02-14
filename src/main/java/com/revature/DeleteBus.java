package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteBus extends HttpServlet {
	public void init() {
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		BusBean bbd=new BusBean();
		bbd.setBusRegNo(req.getParameter("busrnum"));
		PrintWriter out=res.getWriter();
		Connection con = DataBaseConnection.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("delete from bus where Bus_Reg_No=?");
			ps.setString(1,bbd.getBusRegNo());
			int k=ps.executeUpdate();
			if(k>0) {
				out.println("Bus Deleted Successfully...");
			}
			RequestDispatcher rd= req.getRequestDispatcher("/index.html");
			rd.include(req, res);
			
			
		} catch (SQLException e) {
			out.println("Bus Not Deleted...");
			e.printStackTrace();
		}
		
		
		
   
	
}
}
