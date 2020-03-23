package racingcar;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<RacingCar> cars = new ArrayList<>();
    private int raceTime;
    private Random random = new Random();

    private static final int MOVABLE_NUMBER = 3;
    private static final int END_TIME = 0;

    public RacingGame(String[] carNames, int raceTime) {
        createCar(carNames);
        this.raceTime = raceTime;
    }

    private void createCar(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new RacingCar(carName));
        }
    }

    public void startRace() {
        while (canRace()) {
            moveCars();
            reduceCount();
            ResultView.nextLine();
        }
        endRace();
    }

    private void endRace() {
        ResultView.printWinnerName(RacingWinner.findWinnerName(cars));
    }

    private boolean canRace() {
        return this.raceTime > END_TIME;
    }

    private void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            move(cars.get(i));
        }
    }

    private void move(RacingCar car) {
        if (canMove()) {
            car.moveForward();
        }
        printRaceResult(car);
    }

    private void printRaceResult(RacingCar car) {
        ResultView.printCarName(car.getName());
        ResultView.printPosition(car.getPosition());
    }

    private void reduceCount() {
        this.raceTime = raceTime - 1;
    }

    private boolean canMove() {
        return random.nextInt(10) > MOVABLE_NUMBER;
    }

}
