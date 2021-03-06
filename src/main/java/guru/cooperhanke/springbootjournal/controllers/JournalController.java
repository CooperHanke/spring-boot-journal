package guru.cooperhanke.springbootjournal.controllers;

import guru.cooperhanke.springbootjournal.entities.Journal;
import guru.cooperhanke.springbootjournal.repos.JournalRepo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JournalController {

    private JournalRepo repo;

    JournalController(JournalRepo repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public List<Journal> getJournal() {
        return repo.findAll();
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("journal", repo.findAll());
        return "index";
    }
}
