package racingcar.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class Car implements Comparable<Car> {

    private final CarName name;
    private int distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = 0;
    }

    public void run(RunStrategy runStrategy) {
        if (runStrategy.runnable()) {
            this.distance += 1;
        }
    }

    public void run(int numberOfTimes, RunStrategy runStrategy) {
        IntStream.range(0, numberOfTimes).forEach(a -> this.run(runStrategy));
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
