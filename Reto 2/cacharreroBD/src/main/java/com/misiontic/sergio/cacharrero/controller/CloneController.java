
package com.misiontic.sergio.cacharrero.controller;

import com.misiontic.sergio.cacharrero.model.Clone;
import com.misiontic.sergio.cacharrero.service.CloneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nico
 */
@RestController
@CrossOrigin("*")
@RequestMapping("clone")
public class CloneController {
    
    @Autowired
    private CloneService servicio;
    
    @GetMapping("/all")
    public List<Clone> getAll() {
        return servicio.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone) {
        return servicio.save(clone);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone clone){
        return servicio.update(clone);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Integer id){
        servicio.deleteById(id);
    }
}
