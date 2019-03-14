package racinggame.service;

import racinggame.Car;

import java.util.List;
import java.util.Random;

public class CarAdvanceService {

    private static final int RANDOM_LIMIT_NUMBER = 10;
    private static final int ADVANCE_THRESHOLD = 4;

    Random random;

    public CarAdvanceService(Random random) {
        this.random = random;
    }

    public boolean isMovingForward() {
        return random.nextInt(RANDOM_LIMIT_NUMBER) >= ADVANCE_THRESHOLD;
    }

    public void moveForward(List<Car> carList) {
        for( Car curCar : carList ) {
            curCar.setPosition( getNextPosition(curCar.getPosition()));
        }
    }

    public int getNextPosition(int position) {
        if( isMovingForward() )
            return position+1;

        return position;
    }
}