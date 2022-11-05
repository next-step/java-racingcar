package racingGame.dto;

import racingGame.domain.Car;
import racingGame.domain.Cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarsDto {

    List<CarDto> carDtos;
    
    public CarsDto(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public static CarsDto makeCarsDto(Cars cars){
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars.getCars()){
            carDtos.add(CarDto.from(car));
        }
        return new CarsDto(carDtos);
    }

    public List<CarDto> getCarsDto(){
        return Collections.unmodifiableList(carDtos);
    }
}
