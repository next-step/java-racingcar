package racinggame.service;

import racinggame.domain.Car;

import java.util.List;

public class CarAdvanceService {

    static final int ADVANCE_THRESHOLD = 4;

    private RandomValueGenerator randomValueGenerator;

    public CarAdvanceService(RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    public void moveForward(List<Car> cars) {
        for( Car curCar : cars ) {
            moveForward(curCar);
        }
    }

    public void moveForward( Car car ) {
        if( isMovingForward() ) {
            car.moveForward();
        }
    }

    public boolean isMovingForward() {
        return randomValueGenerator.getRandomInteger() >= ADVANCE_THRESHOLD;
    }
}