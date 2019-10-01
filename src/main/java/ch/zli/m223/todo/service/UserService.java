package ch.zli.m223.todo.service;

import ch.zli.m223.todo.domain.Entry;
import ch.zli.m223.todo.domain.User;
import ch.zli.m223.todo.repository.EntryRepository;
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
        Optional<User> optionalUpdatedEntry = findUserById(id);

        if (optionalUpdatedEntry.isPresent()) {
            updatedUser = optionalUpdatedEntry.get();
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
        } else {
            updatedUser = user;
            updatedUser.setId(id);
        }
        return userRepository.saveAndFlush(updatedUser);
    }
}
