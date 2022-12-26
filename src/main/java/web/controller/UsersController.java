package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UsersController {
    @GetMapping()
    public String getUsers(Model model){


        return null;
    }
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model){


        return null;
    }

}
