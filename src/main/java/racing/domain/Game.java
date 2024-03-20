package racing.domain;

import java.util.*;

public class Game {
    private final AttendedCars attendedCars;
    private final RandomGenerator randomGenerator;

    public Game(String nameOfCar) {
        this.attendedCars = new AttendedCars(nameOfCar);
        this.randomGenerator = new RandomGenerator();
    }

    public List<Car> getAttendedCars() {
        return attendedCars.getAttendedCars();
    }

    public List<Car> getWinners() {
        return this.attendedCars.getWinners();
    }

    public void playSession() {
        int[] randomMovePoints = new int[this.attendedCars.getAttendance()];

        for (int i = 0; i < this.attendedCars.getAttendance(); i++) {
            randomMovePoints[i] = randomGenerator.getRandomMovePoint();
        }

        this.attendedCars.moveAttendedCars(randomMovePoints);
    }
}
