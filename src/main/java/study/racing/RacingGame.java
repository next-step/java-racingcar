package study.racing;

import study.racing.model.Car;
import study.racing.ui.InputView;
import study.racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final InputView inputView;
    private final ResultView resultView;

    private List<Car> cars;
    private int time;

    public RacingGame() {
        inputView = new InputView();
        resultView = new ResultView();
        cars = new ArrayList<>();
    }

    public void play() {
        configureGameSettings();

        System.out.println("\n실행 결과\n");

        for(int i=0; i<time; i++) {
            move();
            resultView.printCarPositions(cars);
        }

        resultView.printWinners(cars);
    }

    private void configureGameSettings() {
        String[] carNames = inputView.scanCarNames();
        time = inputView.scanTime();

        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void move() {
        for(Car car : cars) {
            car.move();
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }
}
