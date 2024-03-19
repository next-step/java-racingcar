package racing.domain;

import racing.view.Output;

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

    public void playGame(int numberOfAttempts) {
        if (numberOfAttempts < 0) {
            throw new IllegalArgumentException("시도할 횟수는 음수가 될 수 없습니다.");
        }

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            this.playSession();
            Output.showSessionStatus(this.attendedCars);
        }
    }

    public List<Car> getWinners() {
        return this.attendedCars.getWinners();
    }

    private void playSession() {
        int[] randomMovePoints = new int[this.attendedCars.getAttendance()];

        for (int i = 0; i < this.attendedCars.getAttendance(); i++) {
            randomMovePoints[i] = randomGenerator.getRandomMovePoint();
        }

        this.attendedCars.moveAttendedCars(randomMovePoints);
    }
}
