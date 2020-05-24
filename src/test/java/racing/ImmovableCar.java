package racing;

import edu.next.racing.model.Car;

public class ImmovableCar extends Car {

    public ImmovableCar(String name) {
        super(name);
    }

    @Override
    protected boolean isMoveable() {
        return false;
    }

}
