package step3;

import step2.PositiveInteger;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacingGame {

    private final Scanner scanner;

    public CarRacingGame() {
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        GameStartParameter gameStartParameter = scanGameStartParameters();

        play(gameStartParameter);
    }

    void play(GameStartParameter gameStartParameter) {
        List<Car> cars = generateCars(gameStartParameter);
        runCars(gameStartParameter, cars);
    }

    List<Car> generateCars(GameStartParameter gameStartParameter) {
        return IntStream.range(0, gameStartParameter.getCarNums())
                .mapToObj(i -> new SimpleCar()).collect(Collectors.toList());
    }

    void runCars(GameStartParameter gameStartParameter, List<Car> cars) {
        ResultView.printRunResultText();

        for (int i = 0; i< gameStartParameter.getRunNums(); i++){
            cars.forEach(Car::run);
            ResultView.printCarsRunState(cars);
        }
    }

    GameStartParameter scanGameStartParameters() {
        InputView.printCarNumTakingView();
        int carNums = scanNextPositiveInteger().getIntValue();
        InputView.printTryNumView();
        int runNums = scanNextPositiveInteger().getIntValue();

        return new GameStartParameter(carNums, runNums);
    }

    PositiveInteger scanNextPositiveInteger() {
        return new PositiveInteger(scanner.nextInt());
    }
}
