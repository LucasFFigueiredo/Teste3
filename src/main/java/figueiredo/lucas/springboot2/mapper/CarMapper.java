package figueiredo.lucas.springboot2.mapper;

import figueiredo.lucas.springboot2.domain.Car;
import figueiredo.lucas.springboot2.requests.CarPostRequestBody;
import figueiredo.lucas.springboot2.requests.CarPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CarMapper {
    public static final CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    public abstract Car toCar(CarPostRequestBody carPostRequestBody);

    public abstract Car tocar(CarPutRequestBody carPutRequestBody);
}

// ABANDONADO *************  Voltou
