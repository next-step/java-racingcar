package study.racing;

import study.racing.model.Car;
import study.racing.ui.InputView;
import study.racing.ui.ResultView;
import study.racing.utils.RacingUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MOVE_THRESHOLD = 4;

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
            tryToMove(car);
        }
    }

    private void tryToMove(Car car) {
        if(RacingUtils.getRandomNumber() >= MOVE_THRESHOLD) {
            car.move();
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }
}
