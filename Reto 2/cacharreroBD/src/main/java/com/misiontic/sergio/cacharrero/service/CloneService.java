package com.misiontic.sergio.cacharrero.service;

import com.misiontic.sergio.cacharrero.model.Clone;
import com.misiontic.sergio.cacharrero.repositories.CloneRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nico
 */
@Service
public class CloneService {

    @Autowired
    private CloneRepository repository;

    public List<Clone> getAll() {
        return repository.getAll();
    }

    public Clone save(Clone clone) {
        if (clone.getBrand() == null || clone.getProcesor() == null || clone.getOs() == null || clone.getMemory() == null || clone.getDescription() == null) {
            return clone;
        } else {
            if (clone.getId() == null) {
                return repository.save(clone);
            } else {
                Optional<Clone> existCloneId = repository.getCloneById(clone.getId());
                if (existCloneId.isEmpty()) {
                    return repository.save(clone);
                } else {
                    return clone;
                }
            }
        }

    }

    public Clone update(Clone clone) {
        if (clone.getId() != null) {
            Optional<Clone> cloneExist = repository.getCloneById(clone.getId());
            if (cloneExist.isPresent()) {
                if (clone.getBrand() != null) {
                    cloneExist.get().setBrand(clone.getBrand());
                }
                if (clone.getProcesor() != null) {
                    cloneExist.get().setProcesor(clone.getProcesor());
                }
                if (clone.getOs() != null) {
                    cloneExist.get().setOs(clone.getOs());
                }
                if (clone.getDescription() != null) {
                    cloneExist.get().setDescription(clone.getDescription());
                }
                if (clone.getMemory() != null) {
                    cloneExist.get().setMemory(clone.getMemory());
                }
                if (clone.getHardDrive() != null) {
                    cloneExist.get().setHardDrive(clone.getHardDrive());
                }
                if (clone.isAvailability() != cloneExist.get().isAvailability()) {
                    cloneExist.get().setAvailability(clone.isAvailability());
                }
                if (clone.getPhotography() != null) {
                    cloneExist.get().setPhotography(clone.getPhotography());
                }
                cloneExist.get().setPrice(clone.getPrice());
                cloneExist.get().setQuantity(clone.getQuantity());

                return repository.save(cloneExist.get());
            } else {
                return clone;
            }
        } else {
            return clone;
        }
    }
    
    public void deleteById(Integer id){
        Optional<Clone> cloneExist= repository.getCloneById(id);
        if(cloneExist.isPresent()){
            repository.deleteById(cloneExist.get().getId());
        }
    }

}
