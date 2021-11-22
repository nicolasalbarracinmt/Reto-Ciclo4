
package controller;

import java.util.List;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

/**
 *
 * @author Nico
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService servicio;
    
    @GetMapping("/all")
    public List<User> getUsers(){
        return servicio.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUsers(@RequestBody User user){
        return servicio.save(user);
    }
    
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return servicio.existenciaEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User existUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return servicio.validacionUsuario(email, password);
    }
}
