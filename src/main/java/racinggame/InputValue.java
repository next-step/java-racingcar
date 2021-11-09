package racinggame;

import java.util.Objects;

public class InputValue {

    private final int numberOfCars;
    private final int numberOfAttempts;

    private InputValue(int numberOfCars, int numberOfAttempts) {
        this.numberOfCars = numberOfCars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public static InputValue create(int numberOfCars, int numberOfAttempts) {
        return new InputValue(numberOfCars, numberOfAttempts);
    }

    public int cars() {
        return numberOfCars;
    }

    public int attempts() {
        return numberOfAttempts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputValue that = (InputValue) o;
        return numberOfCars == that.numberOfCars && numberOfAttempts == that.numberOfAttempts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfCars, numberOfAttempts);
    }
}
