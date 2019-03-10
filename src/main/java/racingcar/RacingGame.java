package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private Race race;
    private int moveCount;

    public RacingGame(int carCount, int moveCount) {
        this.moveCount = moveCount;
        this.race = new Race(carCount);
    }

    public void startRace() {
//        System.out.println("자동차 대수: " +  race.carCount() + "\n");
        for (int i = 0; i < moveCount; i++) {
            System.out.println((i + 1) + "번째횟수");
            race.run();
            printCarsDistance();
        }
    }

    private void printCarsDistance() {
        for (Car car : race.getCarList()) {
            printCarDistance(car);
        }
    }

    private void printCarDistance(Car car) {
        StringBuilder raceResult = new StringBuilder();
        for (int i = 0; i < car.getMovingDistance(); i++) {
            raceResult.append("-");
        }
        System.out.println(raceResult.toString());
    }


}

