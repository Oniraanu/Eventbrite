package africa.semicolon.Eventbrite.Services;

import africa.semicolon.Eventbrite.Data.Model.Party;
import africa.semicolon.Eventbrite.Data.Model.User;
import africa.semicolon.Eventbrite.Data.Repository.UserRepository;
import africa.semicolon.Eventbrite.Dto.Request.CreatePartyRequest;
import africa.semicolon.Eventbrite.Dto.Request.LoginUserRequest;
import africa.semicolon.Eventbrite.Dto.Request.RegisterUserRequest;
import africa.semicolon.Eventbrite.Dto.Response.CreatePartyResponse;
import africa.semicolon.Eventbrite.Dto.Response.LoginUserResponse;
import africa.semicolon.Eventbrite.Dto.Response.RegisterUserResponse;
import africa.semicolon.Eventbrite.Exceptions.DuplicateEmailException;
import africa.semicolon.Eventbrite.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    private UserRepository repository;

    private PartyServices services;

    public UserServicesImpl(@Autowired UserRepository repository, @Autowired PartyServices services){
        this.repository = repository;
        this.services = services;
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

    @Override
    public CreatePartyResponse partyResponse(CreatePartyRequest partyRequest) {
        Optional <User> find = repository.findByEmailAddress(partyRequest.getEmailAddress());
        if (find.isEmpty()) throw new RuntimeException("Email does not exist");

        Party party = new Party();
        Mapper.map(partyRequest, party);

        Party savedParty = services.saveParty(party);

        CreatePartyResponse response = new CreatePartyResponse();
        Mapper.map(savedParty, response);

        return response;

    }
}
