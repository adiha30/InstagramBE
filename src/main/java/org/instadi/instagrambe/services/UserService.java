package org.instadi.instagrambe.services;

import org.instadi.instagrambe.UserRepository;
import org.instadi.instagrambe.models.User;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        if (user == null) {
            logger.error("Null user tried to register. Aborting");

            throw new InvalidDataAccessApiUsageException("User cannot be null");
        }

        logger.debug("User {} created.", user);

        return userRepository.save(user);
    }
}
