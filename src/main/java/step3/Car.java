package step3;

import java.util.Objects;

public class Car {

    private final String name;
    private int miles = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new NameLengthException("Name shouldn't be longer than 5 letters.");
        }

        this.name = name;
    }

    public void advance(AdvanceCondition strategy) {
        if (strategy.canAdvance()) {
            this.miles++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMiles() {
        return this.miles;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car)) {
            return false;
        }
        Car car = (Car) obj;
        return name.equals(car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
