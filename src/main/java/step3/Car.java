package step3;

import static step3.AdvanceConstant.*;

public class Car {
    private final StringBuffer location;

    public Car(String initLocation) {
        this.location = new StringBuffer(initLocation);
    }

    public StringBuffer getAdvancedOrDefaultLocation(int randomNumber) {
        if (isAdvance(randomNumber)) {
            return getLocation().append(ADVANCE_STRING);
        }
        return getLocation();
    }

    public StringBuffer getLocation() {
        return location;
    }

    private boolean isAdvance(int randomNumber) {
        return randomNumber >= ADVANCE_COUNT;
    }
}
