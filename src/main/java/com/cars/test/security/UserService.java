package com.cars.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	private final UserDAO applicationUserDao;

	@Autowired
	public UserService(@Qualifier("fake") UserDAO applicationUserDao) {

		this.applicationUserDao = applicationUserDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return applicationUserDao.selectApplicationUserByUsername(username)
				.orElseThrow(() -> 
				new UsernameNotFoundException(String.format("Username %s not found", username)));
	}

}
