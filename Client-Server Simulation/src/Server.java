import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server
{
	private ServerSocket serverSocket;
	
	public Server(int port) throws IOException
	{
	   serverSocket = new ServerSocket(port);
	   serverSocket.setSoTimeout(100000);
	   
	}
	
	public static void main(String args[])
   {
		System.out.println("Enter the port no. : ");
   	Scanner input = new Scanner(System.in);
   	//int portServer = 4321 ;
     int portServer = input.nextInt();
      try
      {
         Server gs = new Server(portServer);
         System.out.println("Server Socket started on port "+portServer);
         while(true){
        	 new Thread(new MultiServerThread(gs.serverSocket.accept())).start();
         }  		   
      }catch(IOException e)
      {
        // e.printStackTrace();
         System.out.println("Worng port entered or Timed out!! Please try again.");
         System.exit(0);
      }
      
      input.close();
   }
   
}