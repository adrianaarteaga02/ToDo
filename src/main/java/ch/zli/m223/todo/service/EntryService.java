package ch.zli.m223.todo.service;

import ch.zli.m223.todo.domain.Entry;
import ch.zli.m223.todo.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
    private EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Optional<Entry> findEntryById(long id) {
        return entryRepository.findById(id);
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.saveAndFlush(entry);
    }

    public void deleteEntryById(long id) {
        if (entryRepository.existsById(id)) {
            entryRepository.deleteById(id);
        }
    }

    public Entry updateEntry(Entry entry, Long id) {
        Entry updatedEntry;
        Optional<Entry> optionalUpdatedEntry = findEntryById(id);

        if (optionalUpdatedEntry.isPresent()) {
            updatedEntry = optionalUpdatedEntry.get();
            updatedEntry.setName(entry.getName());
            updatedEntry.setDescription(entry.getDescription());
            updatedEntry.setToDoList(entry.getToDoList());

        } else {
            updatedEntry = entry;
            updatedEntry.setId(id);
        }
        return entryRepository.saveAndFlush(updatedEntry);
    }
}
