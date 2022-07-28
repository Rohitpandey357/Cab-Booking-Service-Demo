package com.example.cabbookingservice;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cabbookingservice.fileparser.InputParser;

@SpringBootApplication
public class CabbookingserviceApplication {

	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(args[0]);    //file to be scanned  
			InputParser inputParser = new InputParser();
			while(sc.hasNextLine())  {  
				inputParser.parseInput(sc.nextLine());
			}  
			sc.close();     
        
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong.");
            return;
        }
		
	}

}
