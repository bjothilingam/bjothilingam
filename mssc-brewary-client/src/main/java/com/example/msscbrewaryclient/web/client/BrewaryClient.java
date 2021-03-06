package com.example.msscbrewaryclient.web.client;

import com.example.msscbrewaryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.security.PublicKey;
import java.util.UUID;

@ConfigurationProperties(prefix="sfg.brewary", ignoreInvalidFields = false)
@Component
public class BrewaryClient {

    private final RestTemplate restTemplate;

    public String BEER_PATH_V1 = "/api/v1/beer/";

    private String apihost;

    public BrewaryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId) {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID beerId, BeerDto beerDto) {
        restTemplate.put(apihost + BEER_PATH_V1 + beerId.toString(), beerDto);
    }

    public void deleteBeer(UUID beerId) {
        restTemplate.delete(apihost + BEER_PATH_V1 + beerId.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

}
