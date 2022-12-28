package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.DaoImp;
import web.models.User;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    private final DaoImp daoImp;

    public UsersController(DaoImp daoImp) {
        this.daoImp = daoImp;
    }

    @GetMapping
    public String getUsers(Model model){
        model.addAttribute("users", daoImp.getListUsers());
        return "index";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        //daoImp.save("Ali", "Elm");
        return "new";
    }

    @PostMapping("/user")
    public String create(@RequestParam("name") String name,
                         @RequestParam("surname") String surname,
                         Model model) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName(name);
        daoImp.save(user);
        //model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", daoImp.getUserByID(id));
        return "index";
    }

}
