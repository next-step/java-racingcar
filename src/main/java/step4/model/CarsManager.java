package step4.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarsManager implements CarsStrategy {

    private final int RANDOM_BOUND = 10;
    
    @Override
    public void move(Cars cars) {
        for(Car car:cars.getCarList()){
            int movePoint = RandomFactory.getRandomInt(RANDOM_BOUND);
            car.move(movePoint);
        }
    }

    @Override
    public List<Car> arrange(List<Car> carsList) {
        return carsList.stream()
                .sorted( (car1,car2) -> car2.compareTo(car1))
                .collect(Collectors.toList());
    }
}
