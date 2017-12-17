package cloudran;

import java.net.InetAddress;
import java.util.Scanner;

public class CLI extends Thread{

	Scanner scan = new Scanner(System.in);
	
	int id;
	final int port = 50000;
	final String HOST_IP = "79.123.176.50";
	InetAddress addr;
	String response;
	String abort = "abort";
	String createAggregateUser = "aggro";
	String createSpecialUser = "spec";
	String poisson = "p";
	public CLI() {
		//dummy constructor
		id = 0;
		try {
			 addr= InetAddress.getByName(HOST_IP);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		while(true) {
			response = scan.nextLine();
			if(response.equalsIgnoreCase(abort))
				break;
			else if(response.equalsIgnoreCase(createAggregateUser)) {
				new Users("aggro", id, addr, port).start();
				id++;
			}else if(response.equalsIgnoreCase(createSpecialUser)) {
				new Users("special",id,addr,port).start();
				id++;
			}else if(response.equalsIgnoreCase(poisson)){
				System.out.println("new Lambda ?");
				// TODO lamdayi ve k 'yi al bir possion probablity generate et, bunu bir saniyeye(1000 ms ) scale et ve ona gore data generate ettir.
			}else {
				System.out.println("Try again.");
				
			}
			
		}
		
	}
	
}
