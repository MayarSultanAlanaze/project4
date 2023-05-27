package com.example.demo.Controller;


import com.example.demo.Model.Movie;
import com.example.demo.Service.ServiceMovie;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/movie")
public class ControllerMovie {
    private final ServiceMovie serviceMovie;

    @GetMapping("/get")
    public ResponseEntity getAllMovie() {
        List<Movie> MovieList = serviceMovie.getMovie();
        return ResponseEntity.status(200).body(MovieList);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie) {
        serviceMovie.addMovie(movie);
        return ResponseEntity.status(200).body("add movie");
    }

    @PostMapping("/add-check")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie, @PathVariable Integer id) {
        serviceMovie.addMovie(movie);
        return ResponseEntity.status(200).body("add movie");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateMovie(@Valid @RequestBody Movie movie, @PathVariable Integer id, Errors errors) {
        serviceMovie.updatemovie(movie, id);
        return ResponseEntity.status(200).body("update movie");
    }

    @DeleteMapping("/delete/{id }")
    public ResponseEntity deleteMovie(@PathVariable Integer id) {
        serviceMovie.deletemovie(id);
        return ResponseEntity.status(200).body("delete movie");
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getCatgory(@PathVariable String category) {
        List<Movie> movies = serviceMovie.getMovieByCategory(category);
        return ResponseEntity.status(200).body("movie");
    }

    @GetMapping("/get-rating/{rating}")
    public ResponseEntity getRating(@PathVariable Integer rating) {
        List<Movie> movies = serviceMovie.getMovieByRate(rating);
        return ResponseEntity.status(200).body("movie");
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity getName(@PathVariable String name) {
        Movie movies = serviceMovie.getByName(name);
        return ResponseEntity.status(200).body("movie");
    }

    @GetMapping("/get-duration/{name}")
    public ResponseEntity getDurtion(@PathVariable String name) {
        Integer movies = serviceMovie.getDuration(name);
        return ResponseEntity.status(200).body("movie");
    }

    @GetMapping("/get-movie-rate/{name}")
    public ResponseEntity getRateofMovie(@PathVariable String name) {
        Integer movies = serviceMovie.getMovieRate(name);
        return ResponseEntity.status(200).body("movie");
    }
    @GetMapping("/get-list/{name}")
    public ResponseEntity listMovie(@PathVariable String name ) {
        Movie movies = serviceMovie.findMovieByName(name);
        return ResponseEntity.status(200).body("movie");
}
    @GetMapping("/get-dname/{name}")
    public ResponseEntity RetDirectorName(@PathVariable String name ) {
        String movies = serviceMovie.NameRetDirector(name);
        return ResponseEntity.status(200).body("movie");
    }
}

