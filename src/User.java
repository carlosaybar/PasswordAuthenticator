
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
 * this java class gets and sets all the information/credentials
 * for every user
 * @author Carlos Aybar
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
	 * everytime this method is called, the userID will be increased by one
	 */
	public  void setUserID()
	{

	     Random random = new Random();
	     userID = random.nextInt(100);
	}
	
	/**
	 * 
	 * @return the userID
	 */
	public int getUserID()
	{
		return userID;
	}
	
	/**
	 * this method asks the user to input a username
	 */
	public  void setUsername()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please create your username");
		username = input.nextLine();
	}
	
	/**
	 * 
	 * @return wherever is stored in the variable username
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * this method generates a random salt
	 * it stores in the variable hash, which
	 * will be later appended to the password
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
	 * @return returns the salt, stored in the variable hash
	 */
	public String getSalt()
	{
		return hash;
	}
	
	/**
	 * concats the hash(salt) with the inputed password
	 * and stores it in the variable passwordHash
	 */
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
	 * @return retuns the passwordHash
	 */
	public int getPasswordHash()
	{
		System.out.println(passwordHash);
		return passwordHash;
		
	}
	
	
	
	
}
