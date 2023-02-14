package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/View")
public class ShowBuses extends HttpServlet{
	public void init() {
		
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		ArrayList<BusBean> al2= new RetrieveDAO().retrieve();
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		if(al2.size()==0) {
			System.out.println("Buses Not Available");
		}else {
			Iterator<BusBean> itr= al2.iterator();
			while(itr.hasNext()) {
				BusBean bb3=(BusBean)itr.next();
				pw.println(bb3.getBusRegNo()+"&nbsp&nbsp"+bb3.getBusType()+"&nbsp&nbsp"+bb3.getTotalSeats()+"&nbsp&nbsp"+bb3.getTotalBerths()+"<br>");
			}
		}
		RequestDispatcher rd= req.getRequestDispatcher("index.html");
		rd.include(req, res);
		
	}
	public void destroy() {
		
	}
}
