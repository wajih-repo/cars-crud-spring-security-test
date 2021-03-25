package com.cars.test.security;

import static com.cars.test.security.UserRole.ADMIN;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

@Repository("fake")
public class UserDaoServiceImpl implements UserDAO {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserDaoServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<User> selectApplicationUserByUsername(String username) {

		return getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername()))
				.findFirst();

	}

	private List<User> getApplicationUsers() {
		List<User> users = Lists.newArrayList(new User(ADMIN.getGrantedAuthorities(), "admin",
				passwordEncoder.encode("123"), true, true, true, true));
		return users;

	}

}
