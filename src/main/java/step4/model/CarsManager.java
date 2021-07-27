package step4.model;

import step4.RacingApp;

import java.util.List;
import java.util.stream.Collectors;

public class CarsManager implements CarsStrategy {

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
                .sorted( (car1,car2) -> car2.compareTo(car1))
                .collect(Collectors.toList());
    }
}
