
/*
 Carlos Aybar
 Advanced Java
 02/10/20
 This program keeps store a list of users in a csv file
 you can add as many users as you want, at any time
 you can also delete as many users as you want
 if you want to sign in, type the username and password and this program
 will check the credentials stored in the csv to validate them.
 */

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;


/**
 * 
 * @author Missions
 *
 */
public class User {
	public String username;
	public int userID;
	public String hash = "";
	public int passwordHash;
	
/*
	public User(String name, String salt, String password)
	{
		username = name;
		this.hash = salt;
		this.passwordHash = password;
	}
	*/

	/**
	 * 
	 */
	public  void setUserID()
	{

		//userID++;		
	}
	
	/**
	 * 
	 * @return
	 */
	public int getUserID()
	{
		return userID;
	}
	
	/**
	 * 
	 */
	public  void setUsername()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please create your username");
		username = input.nextLine();
		userID++;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * 
	 */
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

	/**
	 * 
	 * @return
	 */
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
	       String Passcode;
	       Passcode = password + hash;
	       passwordHash = Passcode.hashCode();
		
		
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPasswordHash()
	{
		System.out.println(passwordHash);
		return passwordHash;
		
	}
	
	
	
	
}
