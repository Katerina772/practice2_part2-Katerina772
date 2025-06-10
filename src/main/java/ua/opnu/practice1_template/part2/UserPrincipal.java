package ua.opnu.practice1_template.part2;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class UserPrincipal implements UserDetails {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private Collection<? extends GrantedAuthority> authorities;


    // Гетери
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public static UserPrincipal create(User user) {
        UserPrincipal principal = new UserPrincipal();
        principal.id = user.getId();
        principal.username = user.getUsername();
        principal.email = user.getEmail();
        principal.password = user.getPassword();
        principal.authorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().name()));
        return principal;
    }

}
