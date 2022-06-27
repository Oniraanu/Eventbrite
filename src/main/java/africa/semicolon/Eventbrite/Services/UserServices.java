package africa.semicolon.Eventbrite.Services;

import africa.semicolon.Eventbrite.Dto.Request.LoginUserRequest;
import africa.semicolon.Eventbrite.Dto.Request.RegisterUserRequest;
import africa.semicolon.Eventbrite.Dto.Response.LoginUserResponse;
import africa.semicolon.Eventbrite.Dto.Response.RegisterUserResponse;

public interface UserServices {
    RegisterUserResponse register (RegisterUserRequest request);

    LoginUserResponse login (LoginUserRequest loginUserRequest);


}
