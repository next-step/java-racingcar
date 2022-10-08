package racingcar;

import java.util.*;

public class App {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView();
        inputView.printStartScreen(scanner);

        RacingModel racingModel = inputView.userInputRacingInfo();

        List<Car> cars = new ArrayList<>();
        initRacingCar(racingModel, cars);

        ResultView resultView = new ResultView(cars, racingModel);
        racingStartAndPrint(racingModel, cars, resultView);

        scanner.close();
    }

    private static void racingStartAndPrint(RacingModel racingModel, List<Car> cars, ResultView resultView) {
        System.out.println("실행 결과");
        for (int trys = 0; trys < racingModel.getTryCount(); trys++) {
            racingModel.racingStart(cars);
            resultView.printEachRacingStep();
        }
    }

    private static void initRacingCar(RacingModel racingModel, List<Car> cars) {
        for (int carIndex = 0; carIndex < racingModel.getNumberOfCar(); carIndex++) {
            cars.add(new Car());
        }
    }
}
