package step4.model;

import step4.RacingApp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarMoveAndArrangeStrategy implements CarsStrategy {

    private final int RANDOM_BOUND = 10;
    
    @Override
    public void move(Cars cars) {
        for(Car car:cars.getCarList()){
            boolean isForward = RandomFactory.getRandomInt(RANDOM_BOUND) >= RacingApp.MOVE_BOUNDARY;
            car.move(isForward);
        }
    }

    @Override
    public List<Car> arrange(List<Car> carsList) {
        return carsList.stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .collect(Collectors.toList());
    }
}
