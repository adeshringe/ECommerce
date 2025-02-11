package org.example.dbConfig;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MangoDbConfig {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://localhost:27018"))
                .build());
    }

//    @Bean
//    @Primary
//    public MongoClientSettings mongoClientSettings() {
//        return MongoClientSettings.builder()
//                .applyConnectionString(new ConnectionString("mongodb://localhost:27019"))
//                .build();
//    }
}
