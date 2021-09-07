package race.domain;

import race.strategy.MoveCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private String name;

    private List<Boolean> winOrLoseLog = new ArrayList<>();

    public Car() {
    }

    private Car(String name, List<Boolean> winOrLoseLog) {
        this.name = name;
        this.winOrLoseLog = winOrLoseLog;
    }

    public static Car createCar(String name, List<Boolean> winOrLoseLog) {
        return new Car(name, winOrLoseLog);
    }

    public List<Boolean> getWinOrLoseLog() {
        return Collections.unmodifiableList(winOrLoseLog);
    }

    public String getName() {
        return name;
    }

    public void addDistance(MoveCondition moveCondition) {
        boolean result = moveCondition.moveOrNot();
        winOrLoseLog.add(result);
    }

    public int distance() {
        return (int) this.winOrLoseLog.stream()
                .filter(d -> d)
                .count();
    }

}
