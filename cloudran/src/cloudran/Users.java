package cloudran;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Users extends Thread{

	String usertype;
	int id;
	int capacity;
	String aggro = "aggro";
	String special = "special";
	String abort = "abort";
	String payload;
	DatagramPacket[] packets;
	int port;
	InetAddress addr;
	byte[] buf = new byte[256];

	public Users(String type, int id, InetAddress addr, int port) {
		this.id = id;
		usertype = type;
		this.addr = addr;
		this.port = port;

		if (usertype.equalsIgnoreCase(aggro)) {
			capacity = 1000;
			payload = "Aggro User id: " + id + " packet number : ";

		} else if (usertype.equalsIgnoreCase(special)) {
			capacity = 1;
			payload = "Special User id: " + id + " packet number : ";

		} else if (usertype.equalsIgnoreCase(abort)){
			capacity = 1;
			payload = "abort";
		}
		else {
			try {
				this.finalize();

				System.out.println("User yaratilamadi ve silindi");
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		packets = new DatagramPacket[capacity];

		createPackets(packets);
	}

	private void createPackets(DatagramPacket[] packets) {
		// TODO Auto-generated method stub
		String temp = payload;
		for (int i = 0; i < packets.length; i++) {
			temp += i;
			buf = temp.getBytes();
			packets[i] = new DatagramPacket(buf, buf.length, addr, port);
			temp = payload;
		}
	}
	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket();
			for (int i = 0; i < packets.length; i++) {
				socket.send(packets[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
