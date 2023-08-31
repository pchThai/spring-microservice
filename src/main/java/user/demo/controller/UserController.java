package user.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.demo.entity.User;
import user.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User saveduser = userService.createUser(user);
        return new ResponseEntity<>(saveduser, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public  ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping
    public  ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteUser(@PathVariable("id")Long userId){
        return new ResponseEntity<>("User succesfully deleted", HttpStatus.OK);
    }
}
