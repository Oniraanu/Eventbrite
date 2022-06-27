package africa.semicolon.Eventbrite.Services;

import africa.semicolon.Eventbrite.Data.Model.User;
import africa.semicolon.Eventbrite.Data.Repository.UserRepository;
import africa.semicolon.Eventbrite.Dto.Request.LoginUserRequest;
import africa.semicolon.Eventbrite.Dto.Request.RegisterUserRequest;
import africa.semicolon.Eventbrite.Dto.Response.LoginUserResponse;
import africa.semicolon.Eventbrite.Dto.Response.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserRepository repository;

    @Override
    public RegisterUserResponse register(RegisterUserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmailAddress(userRequest.getEmailAddress());
        user.setPassword(userRequest.getPassword());

        User savedUser = repository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmailAddress(savedUser.getEmailAddress());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE,dd/MM/yyyy, hh:mm,a")
                .format(savedUser.getLocalDateTime()));
        return response;
    }

    @Override
    public LoginUserResponse login(LoginUserRequest loginUserRequest) {
        Optional <User> user = repository.findByEmailAddress(loginUserRequest.getEmail());
        if (user.isPresent()) {
            if (user.get().getPassword().equals(loginUserRequest.getPassword())){
                LoginUserResponse loginUserResponse = new LoginUserResponse();
                loginUserResponse.setWelcomeMessage("Welcome " + loginUserResponse.getWelcomeMessage());
                return loginUserResponse;
            }
            else throw new IllegalArgumentException("Incorrect Email or Password");
        }
        else throw new IllegalArgumentException("Incorrect details");
    }

}
