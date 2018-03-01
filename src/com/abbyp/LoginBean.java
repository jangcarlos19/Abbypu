package com.abbyp;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named (value = "login")
@SessionScoped
public class LoginBean implements Serializable{
    private String name;
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        if (name.equals("Hector") && password.equals("123456")){
            return "succes";

        }

        if (name.equals("Daniel") && password.equals("123456789")){
            return "succes2";
        }
        else
            return "failure";
    }

}
