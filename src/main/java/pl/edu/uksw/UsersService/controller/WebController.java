package pl.edu.uksw.UsersService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.uksw.UsersService.entity.User;
import pl.edu.uksw.UsersService.repository.UsersRepository;

/**
 * Created by Nogaz on 06.07.2017.
 */
@RestController
public class WebController {
    @Autowired
    UsersRepository repository;

    @RequestMapping("/user")
    public String getUser(@RequestParam("name") String name){
        final User user = repository.findByUsername(name);
        return user.toString();
    }

    @RequestMapping("/users")
    public String getAllUsers(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        repository.findAll().forEach(user -> sb.append("<div>"+user.toString()+"</div>"));
        sb.append("</htmml>");
        return sb.toString();
    }


    @Transactional
    @RequestMapping("/adduser")
    public String addUser(@RequestParam("name") String username, @RequestParam("password") String password, @RequestParam("email") String email){
        User newUser = new User(username, password, email);
        repository.save(newUser);
        return "User: " + newUser.toString() + " added succesfully!";

    }

    @RequestMapping("/deleteuser")
    public String removeUser(@RequestParam("name") String username){

        repository.delete(repository.findByUsername(username));
        return "User: " + username + " deleted succesfully!";
    }

    @RequestMapping("/changepass")
    public String changePassword(@RequestParam("name") String username, @RequestParam("password") String newPass ){
        User user = repository.findByUsername(username);
        user.setPassword(newPass);
        repository.save(user);
        return "User " + username + " changed password";
    }

    @RequestMapping("/login")
    public boolean validateUser(@RequestParam("name") String name,
                                @RequestParam("password") String password,
                                @RequestParam("email") String email){
        User user = repository.findByUsername(name);
        if( user.getEmail().equals(email) && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }


}
