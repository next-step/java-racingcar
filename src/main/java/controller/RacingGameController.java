package controller;

import model.Car;
import model.MoveStrategy;
import model.RandomMoveStrategy;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameController {
    private final int numberOfRounds;
    private final List<String> carNames;

    public RacingGameController(int numberOfRounds, String carNames) {
        this.carNames = Arrays.asList(carNames.split(","));
        this.numberOfRounds = numberOfRounds;
    }

    public List<Car> startRace(MoveStrategy moveStrategy) {
        List<Car> cars = new ArrayList<>();
        ResultView resultView = new ResultView();

//        for (int i = 0; i < numberOfCars; i++) {
//            cars.add(new Car());
//        }


        for (int i = 0; i < numberOfRounds; i++) {
            for (Car car : cars) {
                car.move(moveStrategy);
            }
            resultView.printRoundResult(cars);
        }
        return cars;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int numOfCars = inputView.getNumberOfCars();
        String carNames = inputView.getCarNames();
        int numOfRounds = inputView.getNumberOfRounds();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        RacingGameController game = new RacingGameController(numOfRounds, carNames);

        System.out.println();
        System.out.println("실행결과");
        List<Car> cars = game.startRace(randomMoveStrategy);
    }

}
