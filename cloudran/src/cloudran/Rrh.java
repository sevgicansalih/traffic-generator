package cloudran;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Rrh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String HOST_IP = "79.123.176.50";
		try {
			
			InetAddress addr = InetAddress.getByName(HOST_IP);

			DatagramSocket socket = new DatagramSocket(50000);
			
			byte[] buf = new byte[256];
			
			DatagramPacket packet = new DatagramPacket(buf,buf.length);
			int i = 0 ;
			while(true) {
			
				socket.receive(packet);
			
				String recieved = new String(packet.getData(),0,packet.getLength()); 

				if(recieved.equalsIgnoreCase("abort")) {
					break;
				}
				
				System.out.println(recieved+ " recieved id: "+i);
				
				i++;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
