package racing;

import edu.next.racing.domain.Car;
import edu.next.racing.domain.CarInterface;

public class TestCar extends Car implements CarInterface {

    private boolean moveflag = false;

    public TestCar(String name, boolean isMoveable) {
        super(name);
        moveflag = isMoveable;
    }

    @Override
    public boolean isMoveable() {
        return moveflag;
    }

}
