package uz.qodirov.jsonrpcserver.user;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonRpcConfiguration {

    @Bean
    public AutoJsonRpcServiceImplExporter jsonRpcServiceImplExporter() {
        return new AutoJsonRpcServiceImplExporter();
    }

}