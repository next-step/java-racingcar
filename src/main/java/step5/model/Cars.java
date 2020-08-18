package step5.model;

import step5.utility.ReturnRandomValue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars =  cars;
    }

    public static Cars makeCars(List<Car> cars){
        return new Cars(cars);
    }

    public Winners findWinners() {
        return new Winners(filterWinners(getMaxPosition()));
    }

    public List<Car> getCars() {
        return cars;
    }

    int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    List<Car> filterWinners(int maxPosition) {
        return cars.stream()
                .filter(car->car.equalsPosition(maxPosition))
                .collect(Collectors.toList());
    }

    public void carsMove(){
        for (Car car : cars) {
            car.move(ReturnRandomValue.returnValue());
        }
    }
}
