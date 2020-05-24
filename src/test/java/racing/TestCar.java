package racing;

import edu.next.racing.model.Car;

public class TestCar extends Car {

    private boolean moveflag = false;

    public TestCar(String name, boolean isMoveable) {
        super(name);
        moveflag = isMoveable;
    }

    @Override
    protected boolean isMoveable() {
        return moveflag;
    }

}
