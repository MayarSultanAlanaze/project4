package com.example.demo.Service;

import com.example.demo.ApiException.AipException;
import com.example.demo.Model.Director;
import com.example.demo.Model.Movie;
import com.example.demo.Repository.RepositoryDirector;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceDirector {
     private final RepositoryDirector repositoryDirector;

     public List<Director> getAllDirector(){
          return repositoryDirector.findAll();
     }
     public void addDirector(Director director){
          repositoryDirector.save(director);
     }

     public Director updateDirector(Director director, Integer id) {
          Director director1 = repositoryDirector.findDirectorById(id);
          if (director1 == null) {
               throw new AipException("not exist");
          }
          director1.setName(director.getName());
          repositoryDirector.save(director1);
          return director1;
     }

     public Director deletedirector(Integer id){
          Director director=repositoryDirector.getById(id);
          if (director==null){
               throw new AipException("Director DELETE");
          }
          repositoryDirector.delete(director);
          return director;
     }

     public  Director findDirectorById(Integer id){
         return repositoryDirector.findDirectorById(id);
     }

     public Director findDirectorByName(String name){
          return repositoryDirector.findDirectorByName(name);
     }
}
