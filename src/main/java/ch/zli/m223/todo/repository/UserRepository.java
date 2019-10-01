package ch.zli.m223.todo.repository;

import ch.zli.m223.todo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
