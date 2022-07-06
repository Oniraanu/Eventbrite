package africa.semicolon.Eventbrite.Data.Repository;

import africa.semicolon.Eventbrite.Data.Model.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartyRepository extends MongoRepository <Party, String> {


}
