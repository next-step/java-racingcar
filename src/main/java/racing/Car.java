package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car implements Comparable<Car>{

    private final int LIMIT_VALUE = 4;

    private List<Integer> moveList;

    private String name;

    private Integer distance;

    public Car() {}

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int moveCnt) {

        moveList = new ArrayList<>();

        for (int i = 0; i < moveCnt; i++) {
            int randomValue = getRandomValue();
            moveList.add(getMoveCount(randomValue));
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

    public Integer getDistance() {
        for(int moveCnt : this.getMoveList()) {
            distance += moveCnt;
        }
        return distance;
    }

    @Override
    public int compareTo(Car car) {
        return car.getDistance().compareTo(this.getDistance());
    }
}
