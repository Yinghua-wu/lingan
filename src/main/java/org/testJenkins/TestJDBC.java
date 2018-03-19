package org.testJenkins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pre=null;
		ResultSet result=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("开始连接数据库");
			String url="jdbc:oracle:"+"thin:@192.168.40.73:1521:ORCL";
			String user="RCP_DEV";
			String password="database";
			con=DriverManager.getConnection(url,user,password);
			System.out.println("连接成功！");
			String sql="select * from RCP_M_COM_CD WHERE COM_CD_KBN=?";
			pre=con.prepareStatement(sql);
			pre.setString(1, "002");
			result=pre.executeQuery();
			while(result.next()){
				System.out.println(result.getString("COM_CD_KBN_NM"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(result != null){
						result.close();
					}else if(pre != null){
						pre.close();
					}else if(con !=null){
						con.close();
					}
					System.out.println("数据库连接已关闭");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
