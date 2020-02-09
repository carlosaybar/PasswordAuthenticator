import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Authenticator {
	static ArrayList<String>credentials = new ArrayList<String>();
	static String credentialsPath = "credentials.csv";
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		User usr = new User();
		usr.setUsername();
		usr.getUsername();
		usr.setSalt();
		usr.getSalt();
		usr.setPasswordHash();
		usr.getPasswordHash();
		FileWriter fileWriter = new FileWriter(credentialsPath , true);
		fileWriter.append(usr.username + "," + usr.passwordHash);
		fileWriter.append("\n");
		fileWriter.close();
		loadUsers(credentialsPath);
		addUser();
		removeUser();
	}

	
	
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
				usr.getUsername();
				usr.setSalt();
				usr.getSalt();
				usr.setPasswordHash();
				usr.getPasswordHash();
				FileWriter fileWriter = new FileWriter(credentialsPath , true);
				fileWriter.append(usr.username + "," + usr.passwordHash);
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
	
	public static int removeUser() throws IOException
	{
		String searchUser;
		Scanner input = new Scanner(System.in);
		System.out.println("type the user to be removed: ");
		searchUser = input.nextLine();
		ArrayList<String>users = new ArrayList<String>();

	/*	
		FileWriter fileWriter = new FileWriter(credentialsPath , true);
		Scanner file = new Scanner (new File(credentialsPath));
		while(file.hasNextLine())
		{
			credentials.add(file.nextLine());
		}
	
		file.close(); // closes the file	*/
		
		System.out.println("before removing");
		for(int i = 0; i < credentials.size(); i++)
		{
			users.add(credentials.get(i));
			System.out.println(users.get(i));
		}
		
		System.out.println("after removing");
		for(int i = 0; i < users.size(); i++)
		{
			if(users.contains(searchUser));
			{
				users.remove(i);
			}

		}
		
		for(int i = 0; i < users.size(); i++)
		{
			System.out.println(users.get(i));

		}

		return 0;
		
	}
	
	public boolean isUserValid(String username, String password)
	{
		
	}
	
}
