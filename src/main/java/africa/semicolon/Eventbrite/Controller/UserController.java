package africa.semicolon.Eventbrite.Controller;

import africa.semicolon.Eventbrite.Dto.Request.LoginUserRequest;
import africa.semicolon.Eventbrite.Dto.Request.RegisterUserRequest;
import africa.semicolon.Eventbrite.Dto.Response.LoginUserResponse;
import africa.semicolon.Eventbrite.Dto.Response.RegisterUserResponse;
import africa.semicolon.Eventbrite.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServices services;

    @PostMapping("/user")
    public ResponseEntity <?> signUp(@RequestBody RegisterUserRequest userRequest){
        try {
            return new ResponseEntity<>(services.register(userRequest), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("login/user")
    public LoginUserResponse login(@RequestBody LoginUserRequest loginUserRequest){
        return services.login(loginUserRequest);
    }

}
