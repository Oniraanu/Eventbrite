package africa.semicolon.Eventbrite.Services;

import africa.semicolon.Eventbrite.Data.Model.Party;
import africa.semicolon.Eventbrite.Data.Repository.PartyRepository;
import africa.semicolon.Eventbrite.Dto.Request.CreatePartyRequest;
import africa.semicolon.Eventbrite.Dto.Response.CreatePartyResponse;
import africa.semicolon.Eventbrite.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartyServicesImpl implements PartyServices{

    @Autowired
    private PartyRepository partyRepository;

    @Override
    public CreatePartyResponse partyResponse(CreatePartyRequest partyRequest) {
        Party party = new Party();
        Mapper.

        return null;
    }
}
