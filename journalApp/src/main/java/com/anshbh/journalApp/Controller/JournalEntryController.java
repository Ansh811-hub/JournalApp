package com.anshbh.journalApp.Controller;

import com.anshbh.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping()
    public List<JournalEntry> getAll(){
        return new ArrayList<JournalEntry>(journalEntries.values());
    }

    @PostMapping()
    public boolean createEntry(@RequestBody JournalEntry journalEntry){
        journalEntries.put(journalEntry.getId(),journalEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myid}")
    public JournalEntry deleteById(@PathVariable Long myid){
        return journalEntries.remove(myid);
    }

    @PutMapping
    public JournalEntry updateEntryById(@RequestBody JournalEntry journalEntry){
        return journalEntries.put(journalEntry.getId(),journalEntry);
    }

}
