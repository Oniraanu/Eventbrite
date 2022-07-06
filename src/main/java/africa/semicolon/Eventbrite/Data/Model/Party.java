package africa.semicolon.Eventbrite.Data.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Party")
@Data
@NoArgsConstructor
public class Party {

    private String id;
    private String name;
    private String location;
}
