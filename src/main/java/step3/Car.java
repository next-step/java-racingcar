package step3;

import java.util.List;

public class Car {

    private final OilTank oilTank;
    private final Location location;

    public Car(OilTank oilTank, Location location) {
        validateNotNull(oilTank, "oilTank");
        validateNotNull(location, "location");
        this.oilTank = oilTank;
        this.location = location;
    }

    private void validateNotNull(Object object, String paramName) {
        if (object == null) {
            throw new IllegalArgumentException(paramName + "is required");
        }
    }

    public void fullAccelerate() {
        while (canAccelerate()) {
            accelerate();
        }
    }

    private boolean canAccelerate() {
        return !oilTank.isEmpty();
    }

    private void accelerate() {
        Power power = oilTank.use();
        location.goForward(power);
    }

    public List<Integer> readTrace() {
        return location.readTrace();
    }

}
