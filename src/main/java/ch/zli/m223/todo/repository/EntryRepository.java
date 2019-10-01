package ch.zli.m223.todo.repository;

import ch.zli.m223.todo.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long>
{
}
