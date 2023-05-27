package com.example.demo.Repository;

import com.example.demo.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMovie extends JpaRepository<Movie,Integer> {

    Movie getMovieById(Integer id);
  Movie findMovieByName(String name);


    Movie getMovieByDirectorID(Integer id);
    Movie getMovieByNameAndDirectorID(String name,String director);
    List<Movie> getMovieByRatingAndGenreThanEqual(Integer rating);

   List<Movie> findMovieByCategory(String category);

    Movie findMovieByGenre(String ganre);
}
