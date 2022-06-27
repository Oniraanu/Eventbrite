package africa.semicolon.Eventbrite.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUserResponse {

    private String welcomeMessage;
    private String lastSeen;
}
