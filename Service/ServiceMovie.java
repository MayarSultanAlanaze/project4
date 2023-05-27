package com.example.demo.Service;

import ch.qos.logback.core.joran.spi.ActionException;
import com.example.demo.ApiException.AipException;
import com.example.demo.Model.Director;
import com.example.demo.Model.Movie;
import com.example.demo.Repository.RepositoryMovie;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceMovie {
    private final RepositoryMovie repositoryMovie;
    private final ServiceDirector serviceDirector;
    public List<Movie> getMovie() {
        return repositoryMovie.findAll();
    }

    public void addMovie(Movie movie) {
        repositoryMovie.save(movie);
    }

    public Movie updatemovie(Movie movie, Integer id) {
        Movie movie1 = repositoryMovie.getById(id);
        if (movie1 == null) {
            movie1.setName(movie.getName());
            movie1.setDuration(movie.getDuration());
            movie1.setRating(movie.getRating());
            movie1.setCategory(movie.getCategory());
            movie1.setDirectorID(movie.getDirectorID());
        }
        repositoryMovie.save(movie1);
        return movie1;

    }

    public Movie deletemovie(Integer id) {
        Movie movie = repositoryMovie.getById(id);
        if (movie == null) {
            throw new AipException("MOVIE DELETE");
        }
        repositoryMovie.delete(movie);
        return movie;
    }

    public Movie getByName(String name) {
       Movie movies= repositoryMovie.findMovieByName(name);
        if (movies == null) {
            throw new AipException("not exist");
        }
        return movies;
    }

    public List<Movie> getMovieByRate(Integer rating) {
       List <Movie> movie = repositoryMovie.getMovieByRatingAndGenreThanEqual(rating);
        if (movie == null) {
            throw new AipException("not exist");
        }
        return movie;
    }
    public List<Movie> getMovieByCategory(String category) {
        List<Movie> movie = repositoryMovie.findMovieByCategory(category);
        if (movie == null) {
            throw new AipException("not exist");
        }
        return movie;
    }
    public Integer getDuration(String name) {
        Movie movie = repositoryMovie.findMovieByName(name);
        if (movie == null) {
            throw new AipException("not exist");
        }
       Integer duration=repositoryMovie.findMovieByName(name).getDuration();
        return duration;

    }
    public Integer getMovieRate(String name) {
        Movie movie = repositoryMovie.findMovieByName(name);
        if (movie == null) {
            throw new AipException("not exist");
        }
        return repositoryMovie.findMovieByName(name).getRating();
    }

    public Movie findMovieByName(String name) {
        if (serviceDirector.findDirectorByName(name)==null) {
            throw new AipException("not exist");
        }
        Director dirctor1=serviceDirector.findDirectorByName(name);
        return repositoryMovie.getMovieByDirectorID(dirctor1.getId());
    }
    public String  NameRetDirector(String name) {
        if (repositoryMovie.findMovieByName(name) == null) {
            throw new AipException("not exist");
        }
        Director Movie = serviceDirector.findDirectorById(repositoryMovie.findMovieByName(name).getDirectorID());
        return Movie.getName();
    }
}



