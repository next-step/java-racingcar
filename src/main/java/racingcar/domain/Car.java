package racingcar.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class Car implements Comparable<Car> {

    private final CarName name;
    private final Position position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position(0);
    }

    public Car(String name, int position){
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public void run(RunStrategy runStrategy) {
        if (runStrategy.runnable()) {
            this.position.move();
        }
    }

    public void run(int numberOfTimes, RunStrategy runStrategy) {
        IntStream.range(0, numberOfTimes).forEach(a -> this.run(runStrategy));
    }

    public String showName() {
        return this.name.toString();
    }

    public int getDistance() {
        return this.position.showPosition();
    }

    public boolean hasSameDistance(Car input) {
        return this.position.equals(input.position);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car o = (Car) obj;
            return this.name.equals(o.name) && this.position.equals(o.position);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }

}
