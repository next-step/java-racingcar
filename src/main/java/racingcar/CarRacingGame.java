package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CarRacingGame {


    public CarRacingGame() {
    }

    public void startGame() {
        GameStartParameter gameStartParameter = scanGameStartParameters();

        play(gameStartParameter);
    }

    void play(GameStartParameter gameStartParameter) {
        CarList cars = new CarList(generateCars(gameStartParameter));
        runCars(gameStartParameter, cars);
        ResultView.printWinners(cars.extractWinners());
    }

    List<SimpleCar> generateCars(GameStartParameter gameStartParameter) {
        return gameStartParameter.getCarNames().stream()
                .map(SimpleCar::new).collect(Collectors.toList());
    }

    private void runCars(GameStartParameter gameStartParameter, CarList cars) {
        ResultView.printRunResultText();

        Stream.iterate(0, i -> i + 1)
                .limit(gameStartParameter.getRunNums())
                .forEach(i -> runCarsAndPrintState(cars));
    }

    private void runCarsAndPrintState(CarList cars) {
        cars.runAllCars();
        ResultView.printCarsRunState(cars);
    }

    private GameStartParameter scanGameStartParameters() {
        InputView.printCarNumTakingView();
        List<String> carNames = InputView.scanCarNames();

        InputView.printTryNumView();
        int runNums = InputView.scanNextPositiveInteger().getIntValue();

        return new GameStartParameter(carNames, runNums);
    }
}
