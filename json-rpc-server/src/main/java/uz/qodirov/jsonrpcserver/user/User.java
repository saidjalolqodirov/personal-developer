package uz.qodirov.jsonrpcserver.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private String middleName;
    private String birthDate;
    private String address;
}
