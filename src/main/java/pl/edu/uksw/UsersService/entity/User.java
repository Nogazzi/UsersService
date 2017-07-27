package pl.edu.uksw.UsersService.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nogaz on 06.07.2017.
 */
@Entity
@Table(name = "users")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public User(){
    }

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(final String username){
        this.username = username;
    }

    public void setPassword(final String password){
        this.password = password;
    }

    public void setEmail(final String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "User[username: " + username + ", pass: " + password + ", email: " + email + "]";
    }
}
