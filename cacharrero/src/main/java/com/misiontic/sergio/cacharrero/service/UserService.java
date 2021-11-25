package com.misiontic.sergio.cacharrero.service;

import java.util.List;
import java.util.Optional;
import com.misiontic.sergio.cacharrero.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.misiontic.sergio.cacharrero.repositories.UserRepository;

/**
 *
 * @author Nico
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    /**
     * 
     * @return 
     */
    public List<User> getAll() {
        return repository.getAll();
    }
    /**
     * 
     * @param user
     * @return 
     */
    
    public User save(User user) {
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return user;

        } else {
            List<User> existUser = repository.getUsersByNameOrEmail(user.getName(), user.getEmail());
            if (existUser.isEmpty()) {
                if (user.getId() == null) {
                    return repository.save(user);

                } else {
                    Optional<User> existUserId = repository.getUserById(user.getId());
                    if (existUserId.isEmpty()) {
                        return repository.save(user);
                    } else {
                        return user;
                    }
                }

            } else {
                return user;
            }
        }

    }

    
    public boolean existenciaEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }
    
    public User validacionUsuario(String email, String password){
        Optional<User> userExist = repository.getLoginAnswer(email, password);
        if (userExist.isPresent()) {
            return userExist.get();
        } else {
            return new User(email, password, "NO DEFINIDO");
        }
    }
}


    



    
