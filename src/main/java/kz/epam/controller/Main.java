package kz.epam.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Khamid_Sarmanov on 1/6/2016.
 */
@Controller
public class Main {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("text", "Hi, welcome");
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logIn(ModelMap model) {
        return "login";
    }


    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
