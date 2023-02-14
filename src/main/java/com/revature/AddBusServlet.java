package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddBusServlet extends HttpServlet {
	public void init() {
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		BusBean bb=new BusBean();
		bb.setBusRegNo(req.getParameter("busrno"));
		bb.setBusType(req.getParameter("bustype"));
		bb.setTotalSeats(Integer.parseInt(req.getParameter("totalseats")));
		bb.setTotalBerths(req.getParameter("berths"));
		
		int k=new InsertDAO().insert(bb);
		res.setContentType("text/html");
		PrintWriter pw= res.getWriter();
		if(k>0) {
			pw.println("Product Updated<br>");
		}
			RequestDispatcher rd= req.getRequestDispatcher("index.html");
			rd.include(req, res);
		
		
	}
	public void destroy() {
		
	}
}
