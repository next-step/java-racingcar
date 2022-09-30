package car.domain;

import car.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;

public class NamingRacingCar implements NamingCar {
    private static final String OUT_PUT_TEXT = "- ";

    private String name;
    private List<Boolean> distance;
    private MovableStrategy movableStrategy;

    private static final int MAX_LENGTH = 5;

    public NamingRacingCar(MovableStrategy movableStrategy) {
        this.distance = new ArrayList<>();
        this.movableStrategy = movableStrategy;
    }

    @Override
    public void racing() {
        if (movableStrategy.isMovable()) {
            distance.add(true);
            return;
        }

        distance.add(false);
    }

    @Override
    public long raceDistance() {
        return distance.stream().filter(d -> d).count();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + " : ");
        for (int i = 0; i < distance.size(); i++) {
            stringBuilder.append(printRace(i));
        }
        return stringBuilder.toString();
    }

    private String printRace(int stage) {
        if (distance.get(stage)) {
            return OUT_PUT_TEXT;
        }
        return "";
    }

    public void inputName(String name) {
        checkNameLength(name.length());
        this.name = name;
    }

    private void checkNameLength(int len) {
        if (MAX_LENGTH < len) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
