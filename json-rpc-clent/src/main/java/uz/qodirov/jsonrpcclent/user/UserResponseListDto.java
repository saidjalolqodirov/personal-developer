package uz.qodirov.jsonrpcclent.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseListDto {
    private List<User> users;
}
