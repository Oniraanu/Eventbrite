package africa.semicolon.Eventbrite.Services;

import africa.semicolon.Eventbrite.Dto.Request.CreatePartyRequest;
import africa.semicolon.Eventbrite.Dto.Response.CreatePartyResponse;

public interface PartyServices {

    CreatePartyResponse partyResponse(CreatePartyRequest partyRequest);
}
