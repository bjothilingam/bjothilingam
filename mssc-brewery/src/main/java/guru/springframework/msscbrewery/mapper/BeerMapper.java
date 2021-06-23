package guru.springframework.msscbrewery.mapper;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    Beer BeerFromBeerDTO(BeerDto beerDto);
    BeerDto BeerDtoFromBeer(Beer beer);
}
