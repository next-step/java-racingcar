package racingcar;

import java.util.List;

public class RacingCar {
    private int distance;
    private String name;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move(RacingCarMoveBehavior racingCarMoveBehavior) {
        distance = racingCarMoveBehavior.action(distance);
    }

    public List<String> isWinner(List<String> winners, int condition) {
        if (distance == condition) {
            winners.add(name);
        }
        return winners;
    }
}
