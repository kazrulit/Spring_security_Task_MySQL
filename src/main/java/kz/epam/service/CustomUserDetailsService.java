package kz.epam.service;

import kz.epam.model.User;
import kz.epam.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khamid_Sarmanov on 1/8/2016.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        User user = userService.findBySso(ssoId);
        if(user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new  org.springframework.security.core.userdetails.User(user.getSsoID(), user.getPassword(),
                user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserProfile userProfile: user.getUserProfiles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }

        return authorities;
    }
}
