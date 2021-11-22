package service;

import java.util.List;
import java.util.Optional;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

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
        if (user.getEmail() == null || user.getPassword() == null || user.getName() == null) {
            return user;
        } else {
            List<User> existUser= repository.getUsersByNameOrEmail(user.getName(), user.getEmail());
            Optional<User> existUserId = repository.getUserById(user.getId());
            if(existUser.isEmpty()){
                if(user.getId()==null){
                    return repository.save(user);
                }else if(existUserId.isEmpty()){
                    return repository.save(user);
                }else{
                    return user;
                }
            }else{
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
