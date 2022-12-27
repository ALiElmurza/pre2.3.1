package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.DaoImp;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    private final DaoImp daoImp = new DaoImp();


    @GetMapping
    public String getUsers(Model model){
        model.addAttribute("messages", daoImp.getListUsers());
        return "index";
    }

    @PutMapping("/add")
    public String addUser(Model model) {
        //model.
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model){
        return null;
    }

}
