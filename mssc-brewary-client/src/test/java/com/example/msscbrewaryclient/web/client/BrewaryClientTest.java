package com.example.msscbrewaryclient.web.client;

import com.example.msscbrewaryclient.web.model.BeerDto;
import com.example.msscbrewaryclient.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
class BrewaryClientTest {

    @Autowired
    BrewaryClient brewaryClient;

    @Test
    void getBeerById() {
        brewaryClient.getBeerById(UUID.randomUUID());
    }

    @Test
    void saveNewBeer() {
        brewaryClient.saveNewBeer(BeerDto.builder().beerName("Bala").beerStyle(BeerStyleEnum.ALE).build());
    }

    @Test
    void updateBeer() {
        brewaryClient.updateBeer(UUID.randomUUID(), BeerDto.builder().beerName("Bala").beerStyle(BeerStyleEnum.ALE).build());
    }

    @Test
    void deleteBeer() {
        brewaryClient.deleteBeer(UUID.randomUUID());
    }


}