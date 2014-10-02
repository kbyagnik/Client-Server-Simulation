CSL458-Special Topics in Computer Science
ASSIGNMENT-1 NETWORK SERVICES USING SOCKETS

Name : KAUSHAL YAGNIK (Entry No. 2012CSB1039)

Task of this assignment is to build a system where any machine which is connected to a network can offer certain services to local or remote machine by using Socket Programming.

______________________________________INSTRUCTIONS FOR EXECUTION :_______________________________________________________________

The attached program is written in JAVA language and hence requires Java Runtime Environment to execute.
1.	The program can be executed using the command the following command in UBUNTU terminal (assuming pwd is the directory where the program is kept):
$ javac Server.java
$ javac Client.java
$ java Server
$ java Client

2.	Alternatively, it can also be executed as a project in an IDE like Eclipse (files in directory workspace/ServiceNetwork/src/) , in multiple consoles.

_________________________________________SOCKET INTRO :_______________________________________________________________________

1.	A server runs on a specific computer and has a socket that is bound to a specific port number. The server just waits, listening to the socket for a client to make a connection request.
2.	To make a connection request, the client tries to connect with the server on the server's machine and port. The client also needs to identify itself to the server so it binds to a local port number that it will use during this connection. This is assigned by the system.
3.	Upon acceptance of connection, the server gets a new socket bound to the same local port and also has its remote endpoint set to the address and port of the client. It needs a new socket so that it can continue to listen to the original socket for connection requests while attending to the needs of the connected client.


______________________________________INPUT/OUTPUT FORMATS :_____________________________________________________________________

FOR SERVER:
Enter the port no. where the server should hear for connection requests from clients.

FOR CLIENT:
Enter the IP address of the server, and then the port no. at which it should send a connection request.

Thereafter, enter the inputs as directed by the services offered by the server. 


_______________________________________WORKING OF THE CODE :____________________________________________________________________ 

	When the Server class is called, it creates a Server Socket which can hear for incoming connections and also sets its timeOut as 100000 millisecs. When the connection is accepted by the server, it spawns a new Thread where some local port is bound to the remote end so that communication starts. The server starts offering services from this bound port to that client while waiting for requests from other clients at the original port. It supports connection of multiple clients by using Threads.

Notes (Assumptions) :
1.	It is necessary to create the server (run the server file) and create a server socket before running the client file.
2.	It is assumed that all the appropriate data files (from where the server fetches the data for services) which are required for the execution are kept at the appropriate locations as mentioned in path variables in the source code.

_______________________________________SERVICES OFFERED :___________________________________________________________________________ 
1.	First service asks the user if he wants to hear Jokes or Puzzles. It sends the joke/puzzle to the client till it gives appropriate reply.
2.	Second service fetches appropriate file from the server and stores it in the file-path given by the user.

