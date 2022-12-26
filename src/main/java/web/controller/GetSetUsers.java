package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetSetUsers {
    @GetMapping(value = "/calc")
    public String printWelcome(@RequestParam(value = "a", required = false) Integer a,
                                   @RequestParam(value = "b", required = false) Integer b,
                               @RequestParam(value = "action", required = false) String action, ModelMap model) {
        Integer c = null;
        if (action != null) {
            switch (action) {
                case ("multiplication"):
                    c = a * b;
                    model.addAttribute("messages", c);
                    break;
                case ("addition"):
                    c = a + b;
                    model.addAttribute("messages", c);
                    break;
                case ("subtraction"):
                    c = a - b;
                    model.addAttribute("messages", c);
                    break;
                case ("division"):
                    c = a / b;
                    model.addAttribute("messages", c);
                    break;
                default: model.addAttribute("messages", "404 :(");
            }
        } else {
            model.addAttribute("messages", "404 :(");
        }
        return "index";
    }

}
