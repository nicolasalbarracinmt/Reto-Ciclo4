
package com.misiontic.sergio.cacharrero.repositories;

import com.misiontic.sergio.cacharrero.crudRepository.CloneCrud;
import com.misiontic.sergio.cacharrero.model.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nico
 */
@Repository
public class CloneRepository {
    
    @Autowired
    private CloneCrud repository;
    
    public List<Clone> getAll(){
        return (List<Clone>) repository.findAll();
    }
    
    public Clone save(Clone clone){
        return repository.save(clone);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Optional<Clone> getCloneById(Integer id){
        return repository.findById(id);
    }
    
}
