package africa.semicolon.Eventbrite.Services;

import africa.semicolon.Eventbrite.Data.Repository.UserRepository;
import africa.semicolon.Eventbrite.Dto.Request.RegisterUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServicesImplTest {

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void registerUserTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmailAddress("Bakreolubunmi@yahoo.com");
        registerUserRequest.setFirstName("Bakre");
        registerUserRequest.setLastName("Olubunmi");
        registerUserRequest.setPassword("qwerty");

        userServices.register(registerUserRequest);

        assertEquals(1, userRepository.count());
    }
}