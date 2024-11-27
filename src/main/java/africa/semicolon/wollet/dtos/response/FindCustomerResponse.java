package africa.semicolon.wollet.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class FindCustomerResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
