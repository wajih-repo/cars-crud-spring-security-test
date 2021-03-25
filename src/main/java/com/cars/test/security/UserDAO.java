package com.cars.test.security;

import java.util.Optional;

public interface UserDAO {

	 Optional<User> selectApplicationUserByUsername(String username);

}
