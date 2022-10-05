package game.controller.dto;

import game.model.Cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarsDto {

    private final List<CarDto> carList;

    public CarsDto(List<CarDto> carList) {
        this.carList = carList;
    }

    public static CarsDto from(Cars cars) {
        return new CarsDto(cars.getCarList().stream()
                .map(CarDto::from)
                .collect(Collectors.toList()));
    }

    public List<CarDto> getLocatedHighPositionCars() {
        List<CarDto> locatedHighPositionCarList = new ArrayList<>();
        for (CarDto carDto : this.carList) {
            addToHighPositionCars(locatedHighPositionCarList, carDto, getMaxPosition());
        }
        return Collections.unmodifiableList(locatedHighPositionCarList);
    }

    private void addToHighPositionCars(List<CarDto> result, CarDto carDto, int maxPosition) {
        if (carDto.getPosition() >= maxPosition) {
            result.add(carDto);
        }
    }
    private int getMaxPosition() {
        return Collections.max(this.carList.stream()
                .map(CarDto::getPosition)
                .collect(Collectors.toList()));
    }

    public List<CarDto> getCarList() {
        return Collections.unmodifiableList(carList);
    }
}
