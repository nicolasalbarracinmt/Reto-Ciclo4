/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.sergio.cacharrero.crudRepository;

import com.misiontic.sergio.cacharrero.model.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author harold
 */
public interface CloneCrud extends MongoRepository<Clone, Integer>{
    
}
