package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final int MINIMUM_NUMBER = 1;

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String[] carNames) {
        if(carNames.length < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("최소 1대 이상 필요합니다.");
        }
        return new Cars(mapCars(carNames));
    }

    private static List<Car> mapCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames) {
            cars.add(Car.of(carName));
        }
        return cars;
    }

    public void moveCars(MovableStrategy movableStrategy) {
        for(Car car : cars){
            car.move(movableStrategy);
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }
}
