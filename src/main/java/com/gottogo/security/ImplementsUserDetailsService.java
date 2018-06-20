package com.gottogo.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.gottogo.model.UserSys;
import com.gottogo.repository.UserSysRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UserSysRepository rep;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			UserSys user = rep.findByusername(username);
			if(username == null) {
				throw new UsernameNotFoundException("Usuario não encontrado!");
			}
		return new User(user.getUsername(),user.getPassword(),true, true, true, true,user.getAuthorities());
	}
	
}
