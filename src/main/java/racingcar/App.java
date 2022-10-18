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

        RacingModel racingModel = new RacingModel(InputView.names, InputView.tryCount);

        RacingCars cars = new RacingCars(new ArrayList<>());
        initRacingCar(racingModel, cars);

        ResultView resultView = new ResultView(cars, racingModel);
        Result result = new Result(resultView);

        result.racingStartAndPrint(racingModel, cars);

        scanner.close();
    }

    private static void initRacingCar(RacingModel racingModel, RacingCars cars) {
        for (int carIndex = 0; carIndex < racingModel.getNumberOfUser(); carIndex++) {
            cars.addCar(new Car(racingModel.getNames()[carIndex],0));
        }
    }
}
