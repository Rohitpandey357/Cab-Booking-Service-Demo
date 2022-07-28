package com.example.cabbookingservice;

import java.io.FileInputStream;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cabbookingservice.fileparser.InputParser;

@SpringBootApplication
public class CabbookingserviceApplication {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream(args[0]);       
			Scanner sc=new Scanner(fis);   //file to be scanned  
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
