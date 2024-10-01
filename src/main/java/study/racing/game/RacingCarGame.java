package study.racing.game;

import study.racing.car.Car;
import study.racing.ui.InputView;
import study.racing.ui.ResultView;

import java.util.ArrayList;
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
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputView.getCarCount(); i++) {
            cars.add(new Car(inputView.getCarNames()[i]));
        }

        resultView.printResult();
        for (int i = 0; i < inputView.getGameCount(); i++) {
            simulate(cars);
            separateRound(i, inputView.getGameCount());
        }

        List<Car> winners = pickWinners(cars);
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

    private List<Car> pickWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getCurrentPosition).max().orElse(0);
        List<Car> winners = cars.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .collect(Collectors.toList());
        return winners;
    }

}
