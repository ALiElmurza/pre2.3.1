package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {
    @GetMapping()
    public String getUsers(Model model){
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("world");
        model.addAttribute("messages", list);

        return "index";
    }
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model){


        return null;
    }

}
