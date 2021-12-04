
package com.misiontic.sergio.cacharrero.repositories;

import java.util.List;
import java.util.Optional;
import com.misiontic.sergio.cacharrero.model.User;
import com.misiontic.sergio.cacharrero.crudRepository.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nico
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrud repository;
    

    
    
    /**
     * 
     * @return 
     */
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    public User save(User user){
        return repository.save(user);
        
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public Optional<User> getUserByName(String name){
        return repository.findByName(name);
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }
    
    /**
     * 
     * @param name
     * @param email
     * @return 
     */
    public List<User> getUsersByNameOrEmail(String name, String email){
        return repository.findByNameOrEmail(name, email);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> getLoginAnswer(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }
    
}




 

  