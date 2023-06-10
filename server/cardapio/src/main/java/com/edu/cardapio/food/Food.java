package com.edu.cardapio.food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//essa classe representa uma tabela ou entidade do DB]
@Table(name = "foods") //dizendo que é uma tabela do DB de nome foods
@Entity(name = "foods") //dizendo que essa tabela representa uma entidade de nome foods
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  //estou dizendo que esse atibuto representa o id na tabela do DB, a primary key
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public Food(FoodRequestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }
}
