package racingcar.model;

import racingcar.utils.NumGenerator;

import java.util.Objects;

public class Car {
    private final int GO_CONDITION = 4;
    private String name;
    private int position;
    private NumGenerator numGenerator;

    private Car() {
    }

    public Car(String name, int position, NumGenerator numGenerator) {
        this.name = name;
        this.position = position;
        this.numGenerator = numGenerator;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int getNumGenerator() {
        return numGenerator.nextInt();
    }

    public void move() {
        if (getNumGenerator() > GO_CONDITION) {
            this.position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
