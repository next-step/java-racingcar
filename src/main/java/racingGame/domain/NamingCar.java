package racingGame.domain;

import racingGame.racingRule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NamingCar implements  Car {

    private final List<Boolean> carTrace = new ArrayList<>();
    private final String carName;
    private final StringBuilder stringBuilder = new StringBuilder();
    private final RacingRule racingRule;

    public NamingCar(String carName, RacingRule racingRule) {
        this.carName = carName;
        this.racingRule = racingRule;
    }

    public String getCarName() {
        return carName;
    }

    public void move() {
        if (racingRule.moveOrNot()) {
            carTrace.add(true);
            return;
        }
        carTrace.add(false);
    }

    public String convertRound(String separator, String mark) {
        stringBuilder.append(carName).append(separator);
        addTrace(mark);
        String round = stringBuilder.toString();
        builderInitial();
        return round;
    }


    private void builderInitial() {
        stringBuilder.setLength(0);
    }

    private void addTrace(String mark) {
        for (int i = 0; i < carTrace.size(); i++) {
            stringBuilder.append(convertTrace(i, mark));
        }
    }

    private String convertTrace(int round, String mark) {
        if (Boolean.TRUE.equals(carTrace.get(round))) {
            return mark;
        }
        return "";
    }

    public long getTraceSize() {
        return carTrace.stream().filter(i -> i).count();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamingCar namingCar = (NamingCar) o;
        return Objects.equals(carTrace, namingCar.carTrace) && Objects.equals(carName, namingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carTrace, carName);
    }


}