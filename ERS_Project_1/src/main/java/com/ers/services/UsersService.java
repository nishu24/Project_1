package com.ers.services;

import com.ers.exception.RecordNotFoundException;
import com.ers.models.Users;
import com.ers.repositories.UsersRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepos usersRepos; // Adding autowired instance of the repository class for Users
    public List<Users> getAllUsersForAdmin(){
        List<Users> usersList = usersRepos.findAll();
        if (usersList.size()>0){
         return usersList;
        }else{
            return new ArrayList<>();
        }
    }

    public Users getAllUsersById(int id) throws RecordNotFoundException {
        Optional<Users> users = usersRepos.findById(id);
        if (users.isPresent()){
            return users.get();
        }else{
            throw new RecordNotFoundException("No user of this ID/Record is found");
        }
    }
}
