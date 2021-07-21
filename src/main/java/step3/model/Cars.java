package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final int RANDOM_BOUND = 4;
    private List<Car> cars;

    public void makeCars(int carCount) {
        cars = new ArrayList<Car>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void moveCars() {
        for(Car car : cars){
            car.move(RandomFactory.getRandomInt(RANDOM_BOUND));
        }
    }
}
