package com.tga104.cga.rest.Controller;

import com.tga104.cga.rest.Models.User;
import com.tga104.cga.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/")
    public String getPage(){
        return "Hello world!!";
    }

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @GetMapping(value="/user/{id}")
    public User getUser(@PathVariable Integer id){
        return userRepo.findById(id).get();
    }

    @PutMapping(value = "/save/user")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "會員已新增...";
    }
    @PatchMapping(value="/update/user/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user){
       User updateUser = userRepo.findById(id).get();
       updateUser.setAge(user.getAge());
       updateUser.setName(user.getName());
       userRepo.save(updateUser);
       return id + "號會員已更新...";
    }
    @DeleteMapping(value = "/delete/user/{id}")
    public String deleteUser(@PathVariable Integer id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return id + "號會員已刪除...";
    }
}
