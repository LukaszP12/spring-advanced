package pl.strefakursow.springadvanced.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.Assert;

public class InMemoryAuthentificationProvider implements AuthenticationProvider {

    private static final String USERNAME_CANNOT_BE_NULL = "Username cannot be null";
    private static final String CREDENTIALS_CANNOT_BE_NULL = "Credentials cannot be null";
    UserDetailsService userDetailsService;

    // it is better in inject using the constructor, as leaves better visibility of the dependencies
    @Autowired
    public InMemoryAuthentificationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            String name = authentication.getName();
            Object credentials = authentication.getCredentials();
            Assert.notNull(name, USERNAME_CANNOT_BE_NULL);
            Assert.notNull(credentials, CREDENTIALS_CANNOT_BE_NULL);

            if (!(credentials instanceof String)) {
                return null; 
            }
            String password = credentials.toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(name);

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(name, password, userDetails.getAuthorities());

        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
