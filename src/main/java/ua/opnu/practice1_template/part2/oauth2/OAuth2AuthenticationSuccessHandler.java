package ua.opnu.practice1_template.part2.oauth2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ua.opnu.practice1_template.part2.TokenProvider;
import ua.opnu.practice1_template.part2.payload.CookieUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private TokenProvider tokenProvider;

    @Autowired
    OAuth2AuthenticationSuccessHandler(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String token = tokenProvider.createToken(authentication);
        CookieUtils.addCookie(response, "token", token, 1800);

        getRedirectStrategy().sendRedirect(request, response, "/");
    }
}
