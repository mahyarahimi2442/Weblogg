package ir.ac.weblogg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PageController {

    @GetMapping("/")
    public String weblog() {
        return "weblog";
    }

    @GetMapping("/login")
    public String login() {return "login";}

    @GetMapping("/register")
    public String register() {return "register";}

    @GetMapping("/category")
    public String addCategory() {return "addCategory";}

    @GetMapping("/addpost")
    public String addPost() {return "addPost";}

    @GetMapping("allpost")
    public String allPost() {return "allPost";}

}

