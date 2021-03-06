package pl.strefakursow.springadvanced.service.implementation;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class InMemoryUserDetailsServiceImpl implements UserDetailsService {

    private static final String USER_WITH_USERNAME_S_DOES_NOT_EXIST = "USER_WITH_USERNAME_S_DOES_NOT_EXIST";

    private List<UserDetails> users;

    public InMemoryUserDetailsServiceImpl() {
        users = new ArrayList<UserDetails>();
        users.add(new User("user","{noop}user", Arrays.asList("USER")));
        users.add(new User("foo","{noop}bar", Arrays.asList("USER")));
        users.add(new User("admin","{noop}admin", Arrays.asList("USER","ADMIN")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Assert.notNull(username,"Username can't be null");
        Optional<UserDetails> optionalUser = users.stream().filter(u -> username.equals(u.getUsername())).findFirst();
        if (!optionalUser.isPresent()){
            throw new UsernameNotFoundException(String.format(USER_WITH_USERNAME_S_DOES_NOT_EXIST,username));
        }

        return optionalUser.get();
    }

}
