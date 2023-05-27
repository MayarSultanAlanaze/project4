package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Table
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "name can't be empty")
    @Column(columnDefinition = "varchar (20) not null")
     @Size(min = 2,message = "should be length more than 2")
    private String name;


    @NotEmpty(message = "genre can't be empty")
    @Column(columnDefinition = "varchar (20) not null check(Category= 'Drama'or'Action'or'Comedy')")
     private String Category;


    @Column(columnDefinition = "varchar (20) not null")
    @NotNull
    @Size(min = 60,message = "must be more than 60")
    private Integer rating;

    @Column(columnDefinition = "varchar (20) not null")
    @NotNull
    private Integer duration;

    @Column(columnDefinition = "varchar (20) not null")
    @NotNull
     private  Integer directorID;


}
