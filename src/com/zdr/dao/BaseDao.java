package com.zdr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springTest?useUnicode=true&characterEncoding=utf8";
	private String user = "root";
	private String password = "rootzdr";
	private Connection conn = null;
	private PreparedStatement pstatm = null;
	private ResultSet result = null;
	
	{
		try {
			Class.forName(driver);
			getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void getConnection(){
		if(conn == null){
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public ResultSet executeQuery(String query,List<Object> params){
		try {
			pstatm = conn.prepareStatement(query);
			if(params!=null&&params.size()>0){
				for (int i = 0; i < params.size(); i++) {
					pstatm.setObject(i+1,params.get(i));
				}
			}
			result = pstatm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int executeUpdate(String query,List<Object> params){
		int rs = 0;
		try {
			pstatm = conn.prepareStatement(query);
			if(params!=null&&params.size()>0){
				for (int i = 0; i < params.size(); i++) {
					pstatm.setObject(i+1,params.get(i));
				}
			}
			rs = pstatm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close(){
		
		try {
			if(result!=null){
				result.close();
				result = null;
			}
			if(pstatm!=null){
				pstatm.close();
				pstatm = null;
			}
			if(conn!=null){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
