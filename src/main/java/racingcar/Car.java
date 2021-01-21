package racingcar;

import java.util.Objects;

public class Car {
    private final String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void play(MoveChecker moveChecker) {
        if (moveChecker.isMoving()) {
            this.location++;
        }
    }

    public void printNameAndCurrentPosition() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
