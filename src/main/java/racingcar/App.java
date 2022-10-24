package racingcar;

import racingcar.race.Car;
import racingcar.race.RacingCars;
import racingcar.race.RacingModel;
import racingcar.race.Result;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView();
        inputView.printStartScreen(scanner);

        RacingCars cars = new RacingCars(new ArrayList<>());
        RacingModel racingModel = new RacingModel(InputView.tryCount);
        initRacingCar(cars);

        ResultView resultView = new ResultView(cars);
        Result result = new Result(resultView);

        result.racingStartAndPrint(racingModel, cars);

        InputView.close();
    }

    private static void initRacingCar(RacingCars cars) {
        for (int carIndex = 0; carIndex < InputView.names.length; carIndex++) {
            cars.addCar(new Car(InputView.names[carIndex], 0));
        }
    }
}
