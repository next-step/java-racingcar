package racingcar.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class Car implements Comparable<Car> {

    private final CarName name;
    private int distance;
    private final RunStrategy runStrategy;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = 0;
        this.runStrategy = new RandomRunStrategy();
    }

    public Car(String name, RunStrategy runStrategy) {
        this.name = new CarName(name);
        this.distance = 0;
        this.runStrategy = runStrategy;
    }

    public void run() {
        if (runStrategy.runnable()) {
            this.distance += 1;
        }
    }

    public void run(int distance) {
        IntStream.range(0, distance).forEach(a -> this.run());
    }

    public String showName() {
        return this.name.toString();
    }

    public int getDistance() {
        return this.distance;
    }


    public boolean hasSameDistance(Car input) {
        return this.distance == input.distance;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.distance, this.distance);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car o = (Car) obj;
            return this.name.equals(o.name) && this.distance == o.distance;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
