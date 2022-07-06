package africa.semicolon.Eventbrite.Services;

import africa.semicolon.Eventbrite.Data.Repository.UserRepository;
import africa.semicolon.Eventbrite.Dto.Request.RegisterUserRequest;
import africa.semicolon.Eventbrite.Exceptions.DuplicateEmailException;
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
        registerMe();

        assertEquals(1, userRepository.count());
    }

    @Test
    public void duplicateEmailThrowsException(){
        registerMe();

        assertThrows(DuplicateEmailException.class, this::registerMe);

        try {
            registerMe();
        }
        catch (DuplicateEmailException exception){
            assertEquals("Bakreolubunmi@yahoo.com already exists", exception.getMessage());
        }
    }

    private void registerMe() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmailAddress("Bakreolubunmi@yahoo.com");
        registerUserRequest.setFirstName("Bakre");
        registerUserRequest.setLastName("Olubunmi");
        registerUserRequest.setPassword("qwerty");
        userServices.register(registerUserRequest);
    }
}