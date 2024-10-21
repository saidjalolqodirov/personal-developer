package uz.qodirov.jsonrpcclent.user;

import com.googlecode.jsonrpc4j.spring.rest.JsonRpcRestClient;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final String JSON_RPC_SERVER_API = "http://localhost:8080/api";

    public User create(User userRequest) {
        try {
            JsonRpcRestClient client = new JsonRpcRestClient(new URL(JSON_RPC_SERVER_API));
            Map<String, Object> params = new HashMap<>();
            params.put("user", userRequest);
            System.out.println("map = " + userRequest);
            return client.invoke("add.user", params, User.class);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Object list() {
        try {
            JsonRpcRestClient client = new JsonRpcRestClient(new URL(JSON_RPC_SERVER_API));
            Object response = client.invoke("list.user", null, Object.class);
            System.out.println("response = " + response);
            return response;
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void delete(Integer id) {
        try {
            JsonRpcRestClient client = new JsonRpcRestClient(new URL(JSON_RPC_SERVER_API));
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            client.invoke("delete.user", params);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
