package racingGame.domain;

import racingGame.racingRule.RacingRule;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car implements Comparable<Car> {

    private int position;
    private String carName;
    private RacingRule racingRule;

    public Car(String carName, RacingRule racingRule) {
        this.carName = carName;
        this.racingRule = racingRule;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void move() {
        if (racingRule.moveOrNot()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String createTrace(String mark) {
        return IntStream.range(0, position)
                .mapToObj(notUsed -> mark)
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }


    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}
