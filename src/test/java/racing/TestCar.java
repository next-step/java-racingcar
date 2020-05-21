package racing;

import edu.next.racing.model.Car;

public class TestCar extends Car {

    public TestCar(String name) {
        super(name);
    }

    @Override
    public boolean isMoveable() {
        return true;
    }

}
