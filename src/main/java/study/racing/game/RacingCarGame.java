package study.racing.game;

import study.racing.car.Car;
import study.racing.view.InputView;
import study.racing.view.ResultView;
import study.racing.winners.Winners;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final InputView inputView;
    private final ResultView resultView = new ResultView();
    private static final int MOVE_CRITERIA = 4;

    public RacingCarGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        List<Car> cars = Arrays.stream(inputView.getCarNames())
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());

        resultView.printResult();
        for (int i = 0; i < inputView.getGameCount(); i++) {
            simulate(cars);
            separateRound(i, inputView.getGameCount());
        }

        List<Car> winners = Winners.pickWinners(cars);
        resultView.gameEnd(winners);
    }

    private void simulate(List<Car> cars) {
        for (Car car : cars) {
            move(car, random());
            resultView.printCarPosition(car);
        }
    }

    private void move(Car car, int randomNumber) {
        if (randomNumber >= MOVE_CRITERIA) {
            car.move();
        }
    }

    private int random() {
        return (int) (Math.random() * 10);
    }

    private void separateRound(int nowRound, int gameCount) {
        if (nowRound != gameCount - 1) {
            resultView.separateGameRound();
        }
    }

}
