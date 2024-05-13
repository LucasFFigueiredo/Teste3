package figueiredo.lucas.springboot2.service;

import figueiredo.lucas.springboot2.domain.Car;
import figueiredo.lucas.springboot2.exception.BadRequestException;
import figueiredo.lucas.springboot2.mapper.CarMapper;
import figueiredo.lucas.springboot2.repository.CarRepository;
import figueiredo.lucas.springboot2.requests.CarPostRequestBody;
import figueiredo.lucas.springboot2.requests.CarPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarsServices {

    private final CarRepository carRepository;

    public List<Car> listAll(){
        return carRepository.findAll();
    }

    public List<Car> findByName(String name){
        return carRepository.findByName(name);
    }
    
    public Car findByIdOrThrowBadRequestException(long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Car not Found"));
    }

    @Transactional
    public Car save(CarPostRequestBody carPostRequestBody){

//        return carRepository.save(Car.builder().name(carPostRequestBody.getName()).build()); RESERVA

        return carRepository.save(CarMapper.INSTANCE.toCar(carPostRequestBody));
    }

    public void delete(long id){
        carRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(CarPutRequestBody carPutRequestBody){

//        Car bdCar = findByIdOrThrowBadRequestException(carPutRequestBody.getId());
//        Car car = Car.builder()
//                .id(bdCar.getId())            RESERVA
//                        .name(carPutRequestBody.getName())
//                                .build();

        Car bdCar = findByIdOrThrowBadRequestException(carPutRequestBody.getId());
        Car car = CarMapper.INSTANCE.tocar(carPutRequestBody);
        car.setId(bdCar.getId());

        carRepository.save(car);
    }

}
