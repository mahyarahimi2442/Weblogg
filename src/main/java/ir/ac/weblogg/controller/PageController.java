package ir.ac.weblogg.controller;


import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/category")
    public String addCategory() {return "addCategory";}

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/addpost")
    public String addPost() {return "addPost";}

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/allpost")
    public String allPost() {return "allPost";}

    @GetMapping ("/postDetails")
    public String postDetails() {return "postDetails";}

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/commentAdmin")
    public String commentAdmin() {return "commentAdmin";}

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/allUser")
    public String allUser() {return "allUser";}



}

