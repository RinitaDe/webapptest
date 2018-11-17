package in.avaali.test.webapp.controller;

import in.avaali.test.webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author  : Rinita De
 */
@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model)
    {

        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }
}

