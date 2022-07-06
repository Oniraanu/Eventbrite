package africa.semicolon.Eventbrite.Dto.Request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatePartyRequest {

    private String emailAddress;
    private String partyName;
    private String partyLocation;
}
