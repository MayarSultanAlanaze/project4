package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "not null")
    @Size(min = 3,message = "should length more than 3")
    private Integer id;

    @NotEmpty(message = "name can't be empty")
    @Column(columnDefinition = "varchar(20)")
    @Size(min = 2, message = "should length more than 2")
    private String Name;
}
