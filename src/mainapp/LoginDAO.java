package mainapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public boolean validate(LoginPojo loginpojo) throws ClassNotFoundException, SQLException {
		String username = loginpojo.getUsername();
		String password = loginpojo.getPassword();
		
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * from USERDETAILS");
		
		while(rs.next())
		{
			if(username.equals(rs.getString("USERNAME")) && password.equals(rs.getString("PASSWORD")))
			{
				con.getConnection().close();
			}
			else
			{
				con.getConnection().close();
				return false;
			}
		}
		
	}

}
