package africa.semicolon.Eventbrite.Data.Repository;

import africa.semicolon.Eventbrite.Data.Model.Party;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartyRepository extends MongoRepository <Party, String> {
    
    Optional <Party> findPartyByName(String name);
}
