package cloudran;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UE {
	
	final static String HOST_IP = "79.123.176.50";
	final static int PORT = 50000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		try {
			
			//InetAddress addr = InetAddress.getByName(HOST_IP);

			//DatagramSocket socket = new DatagramSocket();
			
			//String str = "Hello World";
			
			//byte[] buf = new byte[256];
			
			//buf = str.getBytes();
			
			//DatagramPacket packet = new DatagramPacket(buf,buf.length,addr,PORT);
			//int i = 0;
			
			new CLI().start();
			
			//System.out.println("All data is sent");
			//socket.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
