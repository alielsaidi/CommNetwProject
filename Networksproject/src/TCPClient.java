
import java.io.*; 
import java.net.*; 
class TCPClient { 

    public static void main(String argv[]) throws Exception 
    { 
        String sentence; 
        String modifiedSentence; 
        String chat1 = "" ;

        BufferedReader inFromUser = 
          new BufferedReader(new InputStreamReader(System.in));
        sentence = inFromUser.readLine();
        if(sentence.contentEquals("CONNECT")) {
        	
      	  System.out.println("connection established");
          Socket clientSocket = new Socket("192.168.1.1", 6789); 
          DataOutputStream outToServer = 
                  new DataOutputStream(clientSocket.getOutputStream()); 
                BufferedReader inFromServer = 
                        new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream())); 

        while(true) {
        	if(chat1.contentEquals("disconnect")) {
        		clientSocket.close();
        			
        	}
        	
        	if( inFromUser.ready()) {
        		chat1 = inFromUser.readLine();
           	    outToServer.writeBytes(chat1 + '\n');
        	}
        	if(inFromServer.ready()) {
             

             modifiedSentence = inFromServer.readLine(); 

             System.out.println("FROM SERVER: " + modifiedSentence);

        	}
        }
        
       
        }
    }
}

