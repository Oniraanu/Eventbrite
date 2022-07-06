package africa.semicolon.Eventbrite.Services;

import africa.semicolon.Eventbrite.Data.Model.User;
import africa.semicolon.Eventbrite.Data.Repository.UserRepository;
import africa.semicolon.Eventbrite.Dto.Request.LoginUserRequest;
import africa.semicolon.Eventbrite.Dto.Request.RegisterUserRequest;
import africa.semicolon.Eventbrite.Dto.Response.LoginUserResponse;
import africa.semicolon.Eventbrite.Dto.Response.RegisterUserResponse;
import africa.semicolon.Eventbrite.Exceptions.DuplicateEmailException;
import africa.semicolon.Eventbrite.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    private UserRepository repository;

    public UserServicesImpl(@Autowired UserRepository repository){
        this.repository = repository;
    }
    public UserServicesImpl(){

    }
    @Override
    public RegisterUserResponse register(RegisterUserRequest userRequest) {
        if (repository.existsByEmailAddress(userRequest.getEmailAddress())) throw new DuplicateEmailException("Email Address taken");

        User user = new User();
        Mapper.map(userRequest, user);

        User savedUser = repository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        Mapper.map(savedUser, response);

        return response;
    }

    @Override
    public LoginUserResponse login(LoginUserRequest loginUserRequest) {
        User user = repository.findByEmailAddress(loginUserRequest.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("User not found"));

        if (!user.getPassword().equals(loginUserRequest.getPassword()))
            throw new IllegalArgumentException("Incorrect Password");

        LoginUserResponse loginUserResponse = new LoginUserResponse();
        loginUserResponse.setWelcomeMessage("Welcome " + loginUserResponse.getWelcomeMessage());
        return loginUserResponse;
    }
}
