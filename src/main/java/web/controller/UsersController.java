package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.DaoImp;
import web.models.User;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final DaoImp daoImp;

    public UsersController(DaoImp daoImp) {
        this.daoImp = daoImp;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", daoImp.getListUsers());
        return "index";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        daoImp.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", daoImp.getUserByID(id));
        return "userById";
    }

}
