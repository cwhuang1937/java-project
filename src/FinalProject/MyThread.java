package FinalProject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyThread extends Thread {
	
	public MyThread() {
		try {
			ServerSocket server = new ServerSocket(1357);
			System.out.println("Waiting a player!!!");
			
			Socket s = server.accept();
			System.out.println("Connected !! IP: " + s.getInetAddress());
			while(true) {		
				
				if(Main.isWin) {					
					DataInputStream in = new DataInputStream(s.getInputStream());
					in.read();
					System.out.println("");
				}
				

			}
			
		} catch (IOException e) {
			System.out.println("Disconnected!!!");
		}
	}
}
