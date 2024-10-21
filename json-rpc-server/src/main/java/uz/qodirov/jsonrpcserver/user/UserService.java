package uz.qodirov.jsonrpcserver.user;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

import java.util.List;

@JsonRpcService("/api")
public interface UserService {

    @JsonRpcMethod("add.user")
    User create(@JsonRpcParam(value = "user") User user);

    @JsonRpcMethod("list.user")
    List<User> getAll();

    @JsonRpcMethod("delete.user")
    void deleteById(@JsonRpcParam(value = "id") Integer id);
}
