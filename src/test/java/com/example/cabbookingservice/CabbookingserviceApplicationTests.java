package com.example.cabbookingservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CabbookingserviceApplicationTests {
    
    @Test
    void cabBookingServiceApplicationTestWithInvalidFile() {
        String file[] = {"demo.txt"};
        try {
            CabbookingserviceApplication.main(file);
        } catch (Exception e) {
            assertEquals(FileNotFoundException.class, e.getClass());
        }
    }
}
