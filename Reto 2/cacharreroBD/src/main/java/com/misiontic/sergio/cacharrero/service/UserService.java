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
    
    public Optional<User> userById(Integer id){
        return repository.getUserById(id);
    }
    /**
     * 
     * @param user
     * @return 
     */
    
    public User save(User user) {
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null || user.getIdentification()==null || user.getType()==null) {
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
            return new User();
        }
    }
    
    public User update(User user){
        if(user.getId()!=null){
            Optional<User> userExist = repository.getUserById(user.getId());
            if(userExist.isPresent()){
                if(user.getIdentification()!=null){
                    userExist.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userExist.get().setName(user.getName());
                }
                if(user.getAddress()!=null){
                    userExist.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userExist.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userExist.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userExist.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userExist.get().setType(user.getType());
                }
                return repository.save(userExist.get());
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    
    public Integer deleteById(Integer id){
        Optional<User> userExist= repository.getUserById(id);
        if(userExist.isPresent()){
            repository.deleteById(userExist.get().getId());
            return 0;
        }else{
            return id;
        }
    }
}


    



    
