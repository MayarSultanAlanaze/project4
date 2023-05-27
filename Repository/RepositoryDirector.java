package com.example.demo.Repository;

import com.example.demo.Model.Director;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryDirector extends JpaRepository <Director,Integer> {
    Director findDirectorById(Integer id);

    Director findDirectorByName(String name);

}
