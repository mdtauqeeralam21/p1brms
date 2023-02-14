package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDAO {
	public int k=0;
	public int insert(BusBean bbn) {
		try {
			Connection con=DataBaseConnection.getConnection();
			PreparedStatement ps= con.prepareStatement("insert into bus values(?,?,?,?)");
			ps.setString(1, bbn.getBusRegNo());
			ps.setString(2,bbn.getBusType());
			ps.setInt(3, bbn.getTotalSeats());
			ps.setString(4, bbn.getTotalBerths());
			k= ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
