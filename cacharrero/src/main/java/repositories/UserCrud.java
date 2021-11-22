/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import java.util.Optional;
import model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author harold
 */
public interface UserCrud extends CrudRepository<User, Integer>{
    
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
