package service;

import model.User;

public interface UserService {
	

    User findById(Long id);

    User create(User userToCreate);
}


