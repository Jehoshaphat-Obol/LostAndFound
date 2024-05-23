package com.lostandfound.LostAndFound.service;

import com.lostandfound.LostAndFound.model.FoundModel;
import com.lostandfound.LostAndFound.repository.FoundModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoundModelService {

    private  final FoundModelRepository foundModelRepository;

    @Autowired
    public FoundModelService(FoundModelRepository foundModelRepository){
        this.foundModelRepository = foundModelRepository;
    }

    //save a found model
    public FoundModel saveFoundModel(FoundModel foundModel){
        return  foundModelRepository.save(foundModel);
    }

    //Get all found models
    public List<FoundModel> getAllFoundModels(){
        return  foundModelRepository.findAll();
    }

    //Get a found model by ID
    public  FoundModel getFoundModelById(Long id){
        return  foundModelRepository.findById(id).orElse(null);
    }

    //update a found model
    public  FoundModel updateFoundModel(Long id, FoundModel foundModelDetails){
        FoundModel foundModel = foundModelRepository.findById(id).orElse(null);
        if(foundModel != null){
            foundModel.setName(foundModelDetails.getName());
            foundModel.setDescription(foundModelDetails.getDescription());
            foundModel.setFoundDate(foundModelDetails.getFoundDate());
            foundModel.setFoundLocation(foundModelDetails.getFoundLocation());
            foundModel.setStatus(foundModelDetails.getStatus());
            return  foundModelRepository.save(foundModel);
        }
            return  null;
    }

    //Delete a found model
    public  void deleteFoundModel(Long id){
        foundModelRepository.deleteById(id);
    }
}
