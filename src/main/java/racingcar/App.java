package racingcar;

import racingcar.race.Car;
import racingcar.race.RacingModel;
import racingcar.race.Result;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView();

        RacingModel racingModel = inputView.printStartScreen(scanner);

        List<Car> cars = new ArrayList<>();
        initRacingCar(racingModel, cars);

        ResultView resultView = new ResultView(cars, racingModel);
        Result result = new Result(resultView);

        result.racingStartAndPrint(racingModel, cars);

        scanner.close();
    }

    private static void initRacingCar(RacingModel racingModel, List<Car> cars) {
        for (int carIndex = 0; carIndex < racingModel.getNumberOfCar(); carIndex++) {
            cars.add(new Car());
        }
    }
}
