package racinggame;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class InputValue {

    private final int numberOfCars;
    private final int numberOfAttempts;
    private final List<String> carNames;

    private InputValue(List<String> carNames, int numberOfAttempts) {
        this.numberOfCars = carNames.size();
        this.numberOfAttempts = numberOfAttempts;
        this.carNames = carNames;
    }

    public static InputValue create(List<String> carNames, int numberOfAttempts) {
        return new InputValue(carNames, numberOfAttempts);
    }

    public int cars() {
        return numberOfCars;
    }

    public int attempts() {
        return numberOfAttempts;
    }

    public List<String> carNames() {
        return Collections.unmodifiableList(carNames);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputValue that = (InputValue) o;
        return numberOfCars == that.numberOfCars
                && numberOfAttempts == that.numberOfAttempts
                && carNames.equals(that.carNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfCars, numberOfAttempts, carNames);
    }
}
