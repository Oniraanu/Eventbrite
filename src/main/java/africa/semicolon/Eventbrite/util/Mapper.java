package africa.semicolon.Eventbrite.util;

import africa.semicolon.Eventbrite.Data.Model.User;
import africa.semicolon.Eventbrite.Dto.Request.RegisterUserRequest;
import africa.semicolon.Eventbrite.Dto.Response.RegisterUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {

    public static void map(RegisterUserRequest userRequest, User user){
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmailAddress(userRequest.getEmailAddress());
        user.setPassword(userRequest.getPassword());
    }
    public static void map(User savedUser, RegisterUserResponse response){
        response.setEmailAddress(savedUser.getEmailAddress());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE,dd/MM/yyyy, hh:mm,a")
                .format(savedUser.getLocalDateTime()));
    }
}
