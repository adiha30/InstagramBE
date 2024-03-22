package org.instadi.instagrambe;

import org.instadi.instagrambe.models.User;
import org.instadi.instagrambe.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.google.common.truth.Truth.assertWithMessage;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
public class UserOperationsTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void testCreateUser() {
        User user = new User();

        User createdUser = userService.register(user);

        Assertions.assertAll(
                () -> assertWithMessage("User is null")
                        .that(user)
                        .isNotNull(),
                () -> assertWithMessage("Created user was not saved properly")
                        .that(user)
                        .isEqualTo(createdUser)
        );
    }

    @Test
    @Transactional
    public void testCreateUserWithNullUser() {
        User user = null;

        Assertions.assertThrows(
                InvalidDataAccessApiUsageException.class,
                () -> userService.register(user)
        );
    }
}
