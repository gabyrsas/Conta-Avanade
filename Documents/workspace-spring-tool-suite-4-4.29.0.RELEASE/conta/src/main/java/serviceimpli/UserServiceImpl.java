package serviceimpli;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import model.User;
import repository.UserRepository;


@Service
public class UserServiceImpl {

	 private final UserRepository userRepository;

	    public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    
	    public User findById(Long id) {
	        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	    }

	   
	    public User create(User userToCreate) {
	        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
	            throw new IllegalArgumentException("This Account number already exists.");
	        }
	        return userRepository.save(userToCreate);
	    }
	}
