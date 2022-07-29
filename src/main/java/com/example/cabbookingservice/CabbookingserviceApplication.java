package com.example.cabbookingservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.example.cabbookingservice.fileparser.InputParser;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CabbookingserviceApplication {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			FileInputStream fileInputStream=new FileInputStream(args[0]);       
			Scanner sc=new Scanner(fileInputStream);   //file to be scanned  
			InputParser inputParser = new InputParser();
			while(sc.hasNextLine())  {  
				inputParser.parseInput(sc.nextLine());
			}  
			sc.close();     
        
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw e;
        }
	}
}
