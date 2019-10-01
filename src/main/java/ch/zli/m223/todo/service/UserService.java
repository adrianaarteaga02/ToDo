package ch.zli.m223.todo.service;

import ch.zli.m223.todo.domain.User;
import ch.zli.m223.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void deleteUserById(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public User updateUser(User user, Long id) {
        User updatedUser;
        Optional<User> optionalUpdatedUser = findUserById(id);

        if (optionalUpdatedUser.isPresent()) {
            updatedUser = optionalUpdatedUser.get();
            updatedUser.setFirstname(user.getFirstname());
            updatedUser.setLastname(user.getLastname());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setFirstname(user.getFirstname());

        } else {
            updatedUser = user;
            updatedUser.setId(id);
        }
        return userRepository.saveAndFlush(updatedUser);
    }
}
