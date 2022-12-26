package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {
    @GetMapping
    @ResponseBody
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
