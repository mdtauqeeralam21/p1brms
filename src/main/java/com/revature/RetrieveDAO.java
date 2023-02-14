package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetrieveDAO {
	public ArrayList<BusBean> al= new ArrayList<BusBean>();
	public ArrayList<BusBean> retrieve(){
		try {
		Connection con = DataBaseConnection.getConnection();
		PreparedStatement ps= con.prepareStatement("select*from bus");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			BusBean bb1= new BusBean();
			bb1.setBusRegNo(rs.getString(1));
			bb1.setBusType(rs.getString(2));
			bb1.setTotalSeats(rs.getInt(3));
			bb1.setTotalBerths(rs.getString(4));
			
			al.add(bb1);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}
}
