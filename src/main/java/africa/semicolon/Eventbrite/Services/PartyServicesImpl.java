package africa.semicolon.Eventbrite.Services;

import africa.semicolon.Eventbrite.Data.Model.Party;
import africa.semicolon.Eventbrite.Data.Repository.PartyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartyServicesImpl implements PartyServices{

    @Autowired
    private PartyRepository partyRepository;

    @Override
    public Party saveParty(Party party) {
        return partyRepository.save(party);
    }
}
