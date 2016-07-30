package demo.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Richard Santana
 * @author Marcos Barbero
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		if ("admin".equals(s)) {
			return new User(s, "123", true, true, true, true,
					Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
		}
		throw new UsernameNotFoundException("User not found");
	}
}
