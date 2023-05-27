package com.example.demo.Controller;

import com.example.demo.Model.Director;
import com.example.demo.Model.Movie;
import com.example.demo.Service.ServiceDirector;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/director")
public class ControllerDirector {
    private final ServiceDirector serviceDirector;


    @GetMapping("/get")
    public ResponseEntity getAllDirector(){
      List<Director> directorList =serviceDirector.getAllDirector();
        return ResponseEntity.status(200).body(directorList);
    }
    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director, Errors errors){
       serviceDirector.addDirector(director);
        return ResponseEntity.status(200).body("add director");
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateDirector(@Valid @RequestBody Director director, @PathVariable Integer id, Errors errors) {
       serviceDirector.updateDirector(director, id);
        return ResponseEntity.status(200).body("update director");
    }
    @DeleteMapping("/delete/{id }")
    public ResponseEntity deleteDirector(@PathVariable Integer id ){
        serviceDirector.deletedirector(id);
        return ResponseEntity.status(200).body("delete director");
    }
}
