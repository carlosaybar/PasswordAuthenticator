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


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Missions
 *
 */
public class Authenticator {
	static ArrayList<String>credentials = new ArrayList<String>();
	static String credentialsPath = "credentials.csv";
	

	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		User usr = new User();
		usr.setUsername();
		usr.getUsername();
		usr.setUserID();
		usr.getUserID();
		usr.setSalt();
		usr.getSalt();
		usr.setPasswordHash();
		usr.getPasswordHash();
		FileWriter fileWriter = new FileWriter(credentialsPath , true);
		fileWriter.append(usr.userID + "," + usr.username + "," + usr.passwordHash);
		fileWriter.append("\n");
		fileWriter.close();
		loadUsers(credentialsPath);
		addUser();
		isUserValid();
		removeUser();
	}

	
	/**
	 * 
	 * @param credentialsPath
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static int loadUsers(String credentialsPath) throws IOException, FileNotFoundException
	{
		credentialsPath = ("credentials.csv");
		
		FileWriter fileWriter = new FileWriter(credentialsPath , true);
		Scanner file = new Scanner (new File(credentialsPath));
		int loadUsers = 0;
		while(file.hasNextLine())
		{
			credentials.add(file.nextLine());
			loadUsers++;
		}
		
		file.close(); // closes the file
		return loadUsers;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static int addUser() throws IOException
	{
		User usr = new User();
		Scanner input = new Scanner(System.in);
		boolean isValid = false;
		
		do {
			int answer;
			System.out.println("Enter a 1 if you wish to add a new user and anything else if you dont: ");
			answer = input.nextInt();
			
			if(answer == 1)
			{
				usr.setUsername();
				//usr.getUsername();
				usr.setUserID();
				usr.getUserID();
				usr.setSalt();
				usr.getSalt();
				usr.setPasswordHash();
				usr.getPasswordHash();
				FileWriter fileWriter = new FileWriter(credentialsPath , true);
				fileWriter.append(usr.userID + "," + usr.username + "," + usr.passwordHash);
				fileWriter.append("\n");
				fileWriter.close();
				isValid = true;
			}
			else
			{
				isValid = false;
				break;
			}
		}while(isValid == true);
		return 0;
		
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static int removeUser() throws IOException
	{
		String searchUser;
		Scanner input = new Scanner(System.in);
		System.out.println("type the user to be removed: ");
		searchUser = input.nextLine();


		BufferedReader br = new BufferedReader(new FileReader(credentialsPath));
		String line;

		FileWriter fileWriter = new FileWriter(credentialsPath , true);
		Scanner file = new Scanner (new File(credentialsPath));
		int loadUsers = 0;
		while(file.hasNextLine())
		{
			credentials.add(file.nextLine());
			loadUsers++;
		}

		file.close(); // closes the file


		ArrayList<String>users = new ArrayList<String>();
		users.addAll(credentials);
		System.out.println("this will removed");
		for(int z = 0; z < users.size(); z++)
		{
			line = users.get(z);
			String [] values = line.split(",");
			if(values[z].contentEquals(searchUser))
			{
				System.out.println(users.get(z));
				users.remove(z);
			}

		}
		System.out.println("this is after removing");
		for(int x = 0; x < users.size(); x++)
		{

			System.out.println(users.get(x));
		}
	/*
	//deleting from the csv
	FileWriter fileWriter = new FileWriter(credentialsPath , true);
	Scanner file = new Scanner(new File(credentialsPath));
	for(int i = 0; i < users.size(); i++)
	{
	fileWriter.write(users.get(i));
	fileWriter.append("\n");

	}
	fileWriter.close();
	*/
	return 0;

	}
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static boolean isUserValid() throws IOException
	{
		String inputUsername;
		Scanner input = new Scanner(System.in);
		System.out.println("type the username: ");
		inputUsername = input.nextLine();
		
		String inputPassword;
		System.out.println("type your password: ");
		inputPassword = input.nextLine();
		
		boolean isValid = false;
		BufferedReader br = new BufferedReader(new FileReader(credentialsPath));
		String line;
		
		while(br.readLine() != null)
		{

			line = br.readLine();
			String [] values = line.split(",");
			String found = null;
			
			for(int i = 0; i < values.length; i++)
			{
				if(values[i].contentEquals(inputUsername))
				{
					found = line;
					//System.out.println("remove this" + found);
					isValid = true;
					break;
				
				}
			
				break;
			}
			
			for(int i = 0; i < values.length; i++)
			{
				if(values[i].startsWith(inputPassword))
				{
					found = line;
					//System.out.println("remove this" + found);
					isValid = true;
					break;
				}
			
				break;
			}
			

		}
		
		if(!isValid)
		{
			System.out.println("access granted");
		}
		else
		{
			System.out.println("access denied");
		}

		
		return isValid;	
	}
	
}
