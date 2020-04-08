package mainapp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.io.IOException;

public class Main {
	public static void main() throws NumberFormatException, IOException, ClassNotFoundException, SQLException 
	{
		System.out.println("Register here");
		System.out.println("Login");
		int x;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());
		
		//objects
		RegisterPojo registerpojo= new RegisterPojo();
		RegisterDAO registerdao = new RegisterDAO();
		LoginPojo loginpojo = new LoginPojo();
		LoginDAO logindao = new LoginDAO();
		switch(x) {
		case 1: 
			System.out.println("Enter the first name");
			String firstname=br.readLine();
			System.out.println("Enter the last name");
			String lastname = br.readLine();
			System.out.println("Enter the username");
			String username = br.readLine();
			System.out.println("Enter the Password");
			String password = br.readLine();
			System.out.println("Enter the Email");
			String email= br.readLine();
			
			registerpojo.setFirstname(firstname);
			registerpojo.setLastname(lastname);
			registerpojo.setUsername(username);
			registerpojo.setEmail(email);
			registerpojo.setPassword(password);
			
			registerdao.addUser(registerpojo);
			
			break;
		case 2:
			System.out.println("Enter the username");
			String name = br.readLine();
			System.out.println("Enter the Password");
			String pass = br.readLine();
			loginpojo.setUsername(name);
			loginpojo.setPassword(pass);
			
			if(logindao.validate(loginpojo)==true)
			{
				Luck luck = new Luck();
				luck.display();
			}
			else
				System.out.println("Incorrect Username/password");
			
			break;
		}
	}
}
