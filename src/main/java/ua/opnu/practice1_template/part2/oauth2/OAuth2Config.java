package ua.opnu.practice1_template.part2.oauth2;



import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
@EnableConfigurationProperties(OAuth2ClientProperties.class)
public class OAuth2Config {
    private static final String DEFAULT_REDIRECT_URL = "{baseUrl}/oauth2/callback/{registrationId}";

    private final OAuth2ClientProperties properties;

    public OAuth2Config(OAuth2ClientProperties properties) {
        this.properties = properties;
    }


    private ClientRegistration getRegistration(String client) {
        OAuth2ClientProperties.Registration registration = properties.getRegistration().get(client);

        if (registration == null) {
            return null;
        }

        if ("google".equals(client)) {
            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .scope("email", "profile")
                    .build();
        }

        if ("facebook".equals(client)) {
            return CommonOAuth2Provider.FACEBOOK.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .scope("email", "public_profile")
                    .build();
        }

        return null;
    }
}
