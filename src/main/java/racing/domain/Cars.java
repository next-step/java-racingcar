package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static final int EMPTY_VALUE = 0;
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames){
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int maxMoveCount(){
        return cars
            .stream()
            .mapToInt(Car::getMoveCount)
            .max()
            .orElse(EMPTY_VALUE);
    }
}
