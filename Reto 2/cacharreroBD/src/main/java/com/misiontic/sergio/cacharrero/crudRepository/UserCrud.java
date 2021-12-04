package com.misiontic.sergio.cacharrero.crudRepository;

import java.util.List;
import java.util.Optional;
import com.misiontic.sergio.cacharrero.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Nico
 */
public interface UserCrud extends MongoRepository<User, Integer>{
    
    /**
     * 
     * @param name
     * @return 
     */
    public Optional<User> findByName(String name);
    
    /**
     * 
     * @param email
     * @return 
     */
    public Optional<User> findByEmail(String email);
    
    /**
     * 
     * @param name
     * @param email
     * @return 
     */
    public List<User> findByNameOrEmail(String name, String email);
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
}
