package africa.semicolon.Eventbrite.Dto.Response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {

    private boolean isSuccessful;
    private Object data;
}
