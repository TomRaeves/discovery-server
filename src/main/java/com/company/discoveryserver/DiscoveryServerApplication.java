package com.company.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class DiscoveryServerApplication {

	//https://www.baeldung.com/java-broadcast-multicast

	private static final int receivePort = 4501;  //WELKE MOETEN DIT ZIJN????
	private static final int sendPort = 4500;
	private static final int multicastPort = 3456;
	private static final String multicastAddress = "230.0.0.100";
	private static boolean running = true;

	public static void main(String[] args){
		UDPServer UDP = new UDPServer(receivePort,sendPort);
		UDP.start();
		UDPMultiServer UDPM = new UDPMultiServer(multicastPort,multicastAddress,sendPort);
		UDPM.start();
		System.out.println("starting REST server... To stop the server type in Exit");
		ConfigurableApplicationContext ctx = SpringApplication.run(DiscoveryServerApplication.class, args);
		Scanner sc = new Scanner(System.in);
		while(running){
			String input = sc.nextLine();
			if ("Exit".equals(input)) {
				System.out.println("Stopping UDP server...");
				UDP.shutdown();
				System.out.println("Stopping UDPMulti server...");
				UDPM.shutdown();
				System.out.println("Stopping RESTServer...");
				ctx.close();
				System.out.println("Stopping DiscoveryServer...");
				running = false;
			}
		}
		System.exit(0);
	}

}
