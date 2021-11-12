package racing;

import static helper.StringHelper.throwExceptionNullOrLengthGreaterThan;
import static racing.RacingConstant.*;

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

    public boolean isWinner(int max) {
        return this.step == max;
    }

    private boolean isForward(int random) {
        return random >= FORWARD_STANDARD;
    }
}
