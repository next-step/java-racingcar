package step3.domain.car;

import step3.domain.oil.OilTank;
import step3.domain.oil.Power;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class Car {

    private final OilTank oilTank;
    private final Location location;

    public Car(OilTank oilTank, Location location) {
        checkArgument(oilTank != null, "oilTank is Required");
        checkArgument(location != null, "location is Required");
        this.oilTank = oilTank;
        this.location = location;
    }

    public void fullAccelerate() {
        while (canAccelerate()) {
            accelerate();
        }
    }

    private boolean canAccelerate() {
        return oilTank.isNotEmpty();
    }

    private void accelerate() {
        Power power = oilTank.use();
        location.goForward(power);
    }

    public List<Integer> readTrace() {
        return location.readTrace();
    }

}
