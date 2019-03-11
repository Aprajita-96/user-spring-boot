package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.userservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        User savedUser=userRepository.save(user);
        return savedUser;
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }
    public List<User> getAll(){
        List<User> savedList=(List<User>)userRepository.findAll();
        return savedList;
    }
    public User findUserById(int id){
        Optional<User> save=userRepository.findById(id);
        return save.get();
    }
    public User updateUser(User user,int id){
        Optional<User> save=userRepository.findById(id);
        User fetchedUser=save.get();
        fetchedUser.setId(id);
        fetchedUser.setName(user.getName());
        fetchedUser.setAge(user.getAge());
        fetchedUser.setGender(user.getGender());
        return userRepository.save(fetchedUser);

    }
}
