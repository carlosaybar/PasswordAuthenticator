import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;



public class User {
	public String username;
	public int userID;
	public String hash = "";
	public String passwordHash;
	
/*
	public User(String name, String salt, String password)
	{
		username = name;
		this.hash = salt;
		this.passwordHash = password;
	}
	*/

	public  void setUserID()
	{

		//userID++;		
	}
	
	public int getUserID()
	{
		return userID;
	}
	
	
	public  void setUsername()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please create your username");
		username = input.nextLine();
		userID++;
	}
	public String getUsername()
	{
		return username;
	}
	
	public void setSalt()
	{
        byte x;

       Random RANDOM = new SecureRandom();
       StringBuilder str = new  StringBuilder();

       str.append(hash);

       byte[] salt = new byte[3];
       RANDOM.nextBytes(salt);

       for (int i = 0; i < salt.length; i++) {
       salt[i] = (byte) Math.abs(salt[i]);
       hash = hash + salt[i];



       }
}

	
	public String getSalt()
	{
		return hash;
	}
	
	public  void setPasswordHash()
	{
		Scanner input = new Scanner(System.in);
		String password;
		System.out.println("Plese create your password");
		password = input.nextLine();
		
		
	       StringBuilder str = new  StringBuilder();

	       str.append(hash);
	       
	       passwordHash = password + hash;
		
		
	}
	
	public String getPasswordHash()
	{
		System.out.println(passwordHash);
		return passwordHash;
		
	}
	
	
	
	
}
