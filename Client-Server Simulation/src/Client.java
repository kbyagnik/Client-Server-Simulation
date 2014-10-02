import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client
{
	public static void main(String [] args)
   {
	   Scanner input = new Scanner(System.in);
	   String serverName;
	   System.out.println("Enter the IP address of the server : ");
	   serverName = input.next();
	   System.out.println("Enter the port of the server : ");
      int clientPort = input.nextInt();
      
      //int clientPort = 4321;
      try
      {
         System.out.println("Connecting to " + serverName + " on port " + clientPort);
         Socket clientSocket = new Socket(serverName, clientPort);
         System.out.println("Just connected to " + clientSocket.getRemoteSocketAddress());
         
         BufferedReader inp = new BufferedReader( new InputStreamReader ( clientSocket.getInputStream() ) );
         PrintWriter sendToServer = new PrintWriter(clientSocket.getOutputStream(), true);
         String s1,s;
         
         System.out.println(inp.readLine()+" Waiting for response...");
         s=input.next();
         sendToServer.println(s);
         
         while((s1=inp.readLine()) != null)
         {
        	 System.out.println(s1);
        	 if((s=inp.readLine())==null)
        		 break;
        	 System.out.println(s);
             
        	 s=input.next();
        	 sendToServer.println(s);
         }
         
        int filesize=2022386;
 	    int bytesRead;
 	    int currentTot = 0;		
 		byte [] bytearray  = new byte [filesize];
 		
         InputStream is = clientSocket.getInputStream();
         System.out.println("\nEnter the path to store the incoming file : ");
         String fileName = input.next();
         
         try{
         FileOutputStream fos = new FileOutputStream(fileName);
         BufferedOutputStream bos = new BufferedOutputStream(fos);
         bytesRead = is.read(bytearray,0,bytearray.length);
         currentTot = bytesRead;
         do {
            bytesRead =
               is.read(bytearray, currentTot, (bytearray.length-currentTot));
            if(bytesRead >= 0) currentTot += bytesRead;
         } while(bytesRead > -1);
         
         System.out.println("Writing the downloaded file to : "+fileName);
         bos.write(bytearray,0,bytearray.length);
         //bos.flush();
         bos.close();
         }
         catch(Exception e){
        	// e.printStackTrace();
        	 System.out.println("Wrong filename entered!! Please try again.");
             System.exit(0);
         }
         
         System.out.println("Disconnecting from "+clientSocket.getRemoteSocketAddress()+"...");
         clientSocket.close();
      }catch(IOException e)
      {
        // e.printStackTrace();
         System.out.println("Client cannot connect to the specified address!! Please try again.");
         System.exit(0);
      }
      input.close();
   }
}