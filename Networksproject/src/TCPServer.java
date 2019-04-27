import java.io.*; 
import java.net.*; 

class TCPServer { 

  public static void main(String argv[]) throws Exception 
    { 
      String clientSentence; 
      String capitalizedSentence; 
      String sentence2;
      String chat2="";

      ServerSocket welcomeSocket = new ServerSocket(6789); 
      BufferedReader inFromServer = 
              new BufferedReader(new InputStreamReader(System.in));
      Socket connectionSocket = welcomeSocket.accept(); 

      BufferedReader inFromClient = 
         new BufferedReader(new
         InputStreamReader(connectionSocket.getInputStream())); 
      DataOutputStream  outToClient = 
              new DataOutputStream(connectionSocket.getOutputStream());
            sentence2 = inFromServer.readLine();
            if(sentence2.contentEquals("CONNECT")) {
            	
          	  System.out.println("connection established");
  
      while(true) { 
    	
    	  
  
           if(inFromClient.ready()) {

                 clientSentence = inFromClient.readLine(); 

                 capitalizedSentence = clientSentence.toUpperCase() + '\n'; 

                 
                 System.out.println("USER:"+capitalizedSentence);
           }
                 if( inFromServer.ready()) {                 
                    chat2 = inFromServer.readLine();
                    outToClient.writeBytes(chat2 + '\n');
                 }
              } 
          } 
      } 
}
           
