package study.racing;

import study.racing.model.Car;
import study.racing.view.InputView;
import study.racing.view.ResultView;
import study.racing.utils.RacingUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final InputView inputView;
    private final ResultView resultView;

    private List<Car> carList;
    private int time;

    public RacingGame() {
        inputView = new InputView();
        resultView = new ResultView();
        carList = new ArrayList<>();
    }

    public void play() {
        configureGameSettings();

        System.out.println("\n실행 결과\n");

        for(int i=0; i<time; i++) {
            move();
            resultView.printCarPositions(carList);
        }

        resultView.printWinners(RacingUtils.getWinners(carList));
    }

    private void configureGameSettings() {
        String[] carNames = inputView.scanCarNames();
        time = inputView.scanTime();

        for(String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    private void move() {
        for(Car car : carList) {
            car.move(RacingUtils.getRandomNumber());
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }
}
