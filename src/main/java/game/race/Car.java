package game.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.race.dto.RaceDto;

public class Car {

    private static final int THRESHOLD = 4;

    private String name;
    private int moveCount;

    public Car() {}

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void move() {
        int number = new Random().nextInt(10);
        moveCount += (number > THRESHOLD) ? number : 0;
    }

    public static List<Car> getCars(RaceDto raceDto) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < raceDto.getVehicleCnt(); i++) {
            cars.add(new Car(raceDto.getVehicleNames().get(i)));
        }
        return cars;
    }
}
