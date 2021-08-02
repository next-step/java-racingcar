package race.model;

import racing.model.Car;
import racing.model.RandomMovingStrategy;

public class TestCar extends Car {

    public TestCar(String carName) {
        super(carName);
    }

    public boolean run(int number) {
        if(RandomMovingStrategy.moveCondition(number)) {
            super.run(() -> true);
            return true;
        }
        return false;
    }
}
