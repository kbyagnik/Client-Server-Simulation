import java.io.*;
import java.net.*;

public class MultiServerThread extends Thread{
	Socket server;
	public MultiServerThread(Socket client){
		server = client;
	}
	public void run(){
		 try {		
			 
			 PrintWriter out = new PrintWriter(server.getOutputStream(), true);
			 BufferedReader in = new BufferedReader( new InputStreamReader ( server.getInputStream() ) );
			 System.out.println(server.getRemoteSocketAddress() + " client demands service.");
			 service1(server,out,in);
			 service2(server,out,in);
			 
			 System.out.println("Thank you "+server.getRemoteSocketAddress()+" for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
			 server.close();
			 
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Wrong Input!! Please try again.");
	        
			System.exit(0);
		}
	}
	
	public void service1(Socket server,PrintWriter out,BufferedReader in) throws IOException
	{
		//System.out.println("Starting Entertainment Service...");
		out.println("Enter your choice what you wish get: JOKES or PUZZLES ");
		String choice=in.readLine();
		
		System.out.println("Client "+server.getRemoteSocketAddress()+" wants to get "+choice);
	    
	    String fileName = "/home/master/Desktop/Socket/JOKES";
	    if(choice.equalsIgnoreCase("JOKES"))
	    	fileName= "/home/master/Desktop/Socket/JOKES";
		else if(choice.equalsIgnoreCase("PUZZLES"))
			fileName= "/home/master/Desktop/Socket/PUZZLES";
	    
	    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
	    while(true){
	    out.println(fileReader.readLine()+"\n Do you wish to continue?? (Y/N)");
	    out.flush();
	    
	    if (in.readLine().equalsIgnoreCase("n"))
	    	break;
	    }
	    fileReader.close();
	    
        out.println("Thank you for subscribing to "+choice+". Enter 'OK' to download the file.");
        out.flush();
	}
	
	public void service2(Socket server,PrintWriter out,BufferedReader in) throws IOException
	{
		System.out.println("Starting file-upload service to "+server.getRemoteSocketAddress()+"...");
		File myFile = new File("/home/master/Desktop/Socket/CSL202-Assignment-3.pdf");
        byte [] bytearray  = new byte [(int)myFile.length()];
        FileInputStream fin = new FileInputStream(myFile);
        BufferedInputStream bin = new BufferedInputStream(fin);
        bin.read(bytearray,0,bytearray.length);
        OutputStream os = server.getOutputStream();
        System.out.println("Sending Files...");
        os.write(bytearray,0,bytearray.length);
        os.flush();
        bin.close();
		System.out.println("File Upload to "+server.getRemoteSocketAddress()+" is complete.");
	}
	
}
