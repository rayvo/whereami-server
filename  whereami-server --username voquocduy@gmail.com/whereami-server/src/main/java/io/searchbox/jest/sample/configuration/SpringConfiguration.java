package io.searchbox.jest.sample.configuration;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.ClientConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ferhat
 */
@Configuration
public class SpringConfiguration {

    public
    @Bean
    JestClient jestClient() {
        //String connectionUrl = StringUtils.isNotBlank(System.getenv("SEARCHBOX_URL")) ?
        //        System.getenv("SEARCHBOX_URL") : "http://site:your-api-key@api.searchbox.io";

        //String connectionUrl = "http://localhost:9200";

        String connectionUrl = "http://10.12.26.86:9200";
        // Configuration
        ClientConfig clientConfig = new ClientConfig.Builder(connectionUrl).multiThreaded(true).build();

        // Construct a new Jest client according to configuration via factory
        JestClientFactory factory = new JestClientFactory();
        factory.setClientConfig(clientConfig);
        return factory.getObject();
    }
}
