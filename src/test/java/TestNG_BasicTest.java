import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class TestNG_BasicTest {

@Test
    public void login(){
        System.out.println("login");
    }

    @Test
    public void logout(){
    System.out.println("logout");
    }
}