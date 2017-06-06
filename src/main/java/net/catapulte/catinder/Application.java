package net.catapulte.catinder;

import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MongoDbFactory mongoDbFactory(@Value("${mongo.host:localhost}") String host,
                                         @Value("${mongo.port:27017}") int port,
                                         @Value("${mongo.user:lolcat}") String user,
                                         @Value("${mongo.pass:lolcat}") String pass) throws UnknownHostException {
        MongoClientURI uri = new MongoClientURI(String.format("mongodb://%s:%s@%s:%d/cat", user, pass, host, port));
        SimpleMongoDbFactory f = new SimpleMongoDbFactory(uri);
        return f;
    }
}
