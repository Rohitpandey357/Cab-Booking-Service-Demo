package com.example.cabbookingservice.modelservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.util.Pair;

import com.example.cabbookingservice.models.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private User user;

    @BeforeEach
    public void init() {
        user = new User("Rahul", "M", 27);    
    }

    @Test 
    public void addThrowsNullPointerException() {
        User user = null;
        try {
            new UserService().add(user);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    public void addUserTest() {
        UserService spyUserService = spy(UserService.class);
        assertEquals(0, spyUserService.getUsers().size());
        spyUserService.add(user);
        assertEquals(1, spyUserService.getUsers().size());
        assertEquals(user, spyUserService.getUsers().get("Rahul"));
    }

    @Test
    public void updateUserLocationThrowsNullPointerException() {
        String name = null;
        try {
            new UserService().updateUserLocation(name, null);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    public void updateUserLocationTest() {
        UserService spyUserService = spy(UserService.class);
        spyUserService.getUsers().put("Rahul", user);
        assertNull(spyUserService.getUsers().get("Rahul").getLocation());
        spyUserService.updateUserLocation("Rahul", Pair.of(10f, 10f));
        assertEquals(Pair.of(10f, 10f), spyUserService.getUsers().get("Rahul").getLocation());
    }

    @Test
    public void updateUserThrowsNullPointerExceptionTest() {
        String name = null;
        try {
            new UserService().updateUser(name, null);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test 
    public void updateUserTest() {
        UserService spyUserService = spy(UserService.class);
        spyUserService.getUsers().put("Rahul", user);
        assertNull(spyUserService.getUsers().get("Rahul").getContactNumber());
        spyUserService.updateUser("Rahul", "78384646");
        assertEquals("78384646", spyUserService.getUsers().get("Rahul").getContactNumber());
    }
}
