package study.racing;

import study.racing.model.Car;
import study.racing.ui.InputView;
import study.racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_RANDOM_NUM = 10;

    private final InputView inputView;
    private final ResultView resultView;

    private List<Car> cars;
    private int time;

    public RacingGame() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public RacingGame(int numOfCars, int time) {
        inputView = new InputView();
        resultView = new ResultView();

        cars = new ArrayList<>();
        for(int i=0; i<numOfCars; i++) {
            cars.add(new Car());
        }

        this.time = time;
    }

    public void play() {
        if(cars == null) {
            configureGameSettings();
        }

        System.out.println("\n실행 결과\n");

        for(int i=0; i<time; i++) {
            move();
            resultView.printCarPositions(cars);
        }
    }

    private void configureGameSettings() {
        int numOfCars = inputView.scanIntWithQuestion("자동차 대수는 몇 대 인가요?");
        this.time = inputView.scanIntWithQuestion("시도할 회수는 몇 회 인가요?");

        cars = new ArrayList<>();
        for(int i=0; i<numOfCars; i++) {
            cars.add(new Car());
        }
    }

    private void move() {
        for(Car car : cars) {
            if(canMove()) {
                car.move();
            }
        }
    }

    private boolean canMove() {
        return getRandomNumber() >= MOVE_THRESHOLD;
    }

    private int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUM);
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }
}
