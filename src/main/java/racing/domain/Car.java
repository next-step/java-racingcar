package racing.domain;

import static utility.StringHelper.throwExceptionNullOrLengthGreaterThan;
import static racing.constant.RacingConstant.*;

/**
 * @author han
 */
public class Car {

    private final int step;
    private final String name;

    private Car(int step, String name) {
        throwExceptionNullOrLengthGreaterThan(name, LIMIT_LENGTH_OF_NAME);
        this.step = step;
        this.name = name;
    }

    public int getStep() {
        return this.step;
    }

    public String getName() {
        return this.name;
    }

    public static Car create(String name) {
        return new Car(0, name);
    }

    public Car getInstanceByForward(int random) {
        if (isForward(random)) {
            return new Car(Math.addExact(this.step, 1), this.name);
        }
        return this;
    }

    public boolean hasEqualTo(int step) {
        return this.step == step;
    }

    private boolean isForward(int random) {
        return random >= FORWARD_STANDARD;
    }
}
