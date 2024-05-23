package com.lostandfound.LostAndFound.controller;

import com.lostandfound.LostAndFound.model.FoundModel;
import com.lostandfound.LostAndFound.service.FoundModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foundmodels")
public class FoundModelController {

    private final FoundModelService foundModelService;

    @Autowired
    public FoundModelController(FoundModelService foundModelService){
        this.foundModelService = foundModelService;
    }

    //Endpoint to save a found model
    @PostMapping("save")
    public ResponseEntity<FoundModel> saveFoundModel(@RequestBody FoundModel foundModel){
        FoundModel savedFoundModel = foundModelService.saveFoundModel(foundModel);
        return new ResponseEntity<>(savedFoundModel, HttpStatus.CREATED);
    }

    //Endpoint to get a found all
    @GetMapping("all")
    public  ResponseEntity<List<FoundModel>> getFoundModelAll(){
        List<FoundModel> foundModels = foundModelService.getAllFoundModels();
        return new ResponseEntity<>(foundModels, HttpStatus.OK);
    }

    //Endpoint to get a found model by ID
    @GetMapping("/{id}")
    public ResponseEntity<FoundModel> getFoundModelById(@PathVariable("id") Long id){
        FoundModel foundModel = foundModelService.getFoundModelById(id);
        if(foundModel != null){
            return new ResponseEntity<>(foundModel, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Endpoint to delete a found model
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteFoundModel(@PathVariable("id") Long id ){
        foundModelService.deleteFoundModel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
