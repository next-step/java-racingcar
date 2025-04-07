package controller;

import model.Car;
import model.MoveStrategy;
import model.RandomMoveStrategy;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private final int numberOfRounds;
    private final List<Car> cars;
    private int winningPosition;

    public RacingGameController(int numberOfRounds, String carNames) {
        String[] names = carNames.split(",");
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.numberOfRounds = numberOfRounds;
        this.winningPosition = 0;

    }

    public List<Car> startRace(MoveStrategy moveStrategy) {
        ResultView resultView = new ResultView();

        for (int i = 0; i < numberOfRounds; i++) {
            for (Car car : cars) {
                int position = car.move(moveStrategy);
                updateWinningPosition(position);
            }
            resultView.printRoundResult(cars);
        }

        resultView.printResult(cars, winningPosition);
        return cars;
    }

    public void updateWinningPosition(int position) {
        if (position > winningPosition) {
            winningPosition = position;
        }
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carNames = inputView.getCarNames();
        int numOfRounds = inputView.getNumberOfRounds();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        RacingGameController game = new RacingGameController(numOfRounds, carNames);

        System.out.println();
        System.out.println("실행결과");
        game.startRace(randomMoveStrategy);
    }

}
