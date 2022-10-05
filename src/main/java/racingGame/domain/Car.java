package racingGame.domain;

import racingGame.racingRule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car implements Comparable<Car> {

    private final List<Boolean> carTrace = new ArrayList<>();
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void move(RacingRule racingRule) {
        if (racingRule.moveOrNot()) {
            carTrace.add(true);
            return;
        }
        carTrace.add(false);
    }

    public String convertRound(String separator, String mark) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carName).append(separator);
        for (int i = 0; i < carTrace.size(); i++) {
            stringBuilder.append(convertTrace(i, mark));
        }
        return stringBuilder.toString();
    }

    private String convertTrace(int round, String mark) {
        if (Boolean.TRUE.equals(carTrace.get(round))) {
            return mark;
        }
        return "";
    }

    public long getTraceSize() {
        return carTrace.stream().filter(i->i).count();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carTrace, car.carTrace) && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carTrace, carName);
    }

    @Override
    public int compareTo(Car o) {
        return Math.toIntExact(this.getTraceSize() - o.getTraceSize());
    }
}