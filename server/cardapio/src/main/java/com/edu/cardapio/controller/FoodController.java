package com.edu.cardapio.controller;

import com.edu.cardapio.food.Food;
import com.edu.cardapio.food.FoodRepository;
import com.edu.cardapio.food.FoodRequestDTO;
import com.edu.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //indicando que essa classe é um controller
@RequestMapping("food")  //mapeando o request que vai cair nesse controller, no caso todo request que vier do endpoint "food"
public class FoodController {
    @Autowired  //indica ao spring que quando forr estanciar a classe Foodontroller ele tem que injetar a dependencia autimaticamente
    private FoodRepository repository;

    //esse metodo adiciona itens ao banco de dados
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    //esse metodo pega todos os itens da tabela food no DB
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping  //dizendo ao sppring que esse metodo vai ser chamado quando o endpoint é chamado no metodo get
    public List<FoodResponseDTO> getALl() {
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
