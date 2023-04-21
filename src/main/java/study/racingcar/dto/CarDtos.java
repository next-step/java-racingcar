package study.racingcar.dto;

import java.util.List;

public class CarDtos {

    private List<CarDto> carDtos;

    public CarDtos(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public List<CarDto> getCarDtos() {
        return this.carDtos;
    }

}
