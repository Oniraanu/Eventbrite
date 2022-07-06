package africa.semicolon.Eventbrite.Dto.Response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatePartyResponse {

    private String partyName;
    private String partyLocation;
    private String partyDate;
}
