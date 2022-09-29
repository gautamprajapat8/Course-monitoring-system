package com.masai.utility;

import java.sql.Connection;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.ProvideConnection() ;
		System.out.println(conn);
	}

}
