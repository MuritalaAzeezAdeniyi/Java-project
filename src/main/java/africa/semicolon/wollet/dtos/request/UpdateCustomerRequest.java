package africa.semicolon.wollet.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerRequest {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
