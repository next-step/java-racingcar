package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car implements Comparable<Car> {

    private final int LIMIT_VALUE = 4;

    private List<Integer> moveList;

    private String name;

    private Integer totalDistance = 0;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void move(int moveCnt) {

        moveList = new ArrayList<>();

        for (int i = 0; i < moveCnt; i++) {
            int randomValue = getRandomValue();
            int moveDistance = getMoveCount(randomValue);
            moveList.add(moveDistance);
            totalDistance += moveDistance;
        }

    }

    public int getMoveCount(int randomValue) {
        if (randomValue >= LIMIT_VALUE) {
            return 1;
        }

        return 0;
    }

    public int getRandomValue() {

        return new Random().nextInt(10);

    }

    public List<Integer> getMoveList() {
        return moveList;
    }

    public String getName() {
        return name;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    @Override
    public int compareTo(Car car) {
        return totalDistance.compareTo(car.getTotalDistance());
    }
}
