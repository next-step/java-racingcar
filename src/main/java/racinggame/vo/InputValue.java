package racinggame.vo;

import racinggame.domain.value.Names;

import java.util.List;
import java.util.Objects;

public class InputValue {

    private final int numberOfCars;
    private final int numberOfAttempts;
    private final Names carNames;

    private InputValue(Names carNames, int numberOfAttempts) {
        this.numberOfCars = carNames.count();
        this.numberOfAttempts = numberOfAttempts;
        this.carNames = carNames;
    }

    public static InputValue create(Names carNames, int numberOfAttempts) {
        return new InputValue(carNames, numberOfAttempts);
    }

    public int attempts() {
        return numberOfAttempts;
    }

    public List<String> carNames() {
        return carNames.names();
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
