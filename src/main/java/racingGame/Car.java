package racingGame;

import racingGame.racingRule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(RacingRule racingRule) {
        if (racingRule.createRandomResult()) {
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

}
