package step3;

import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CarRacingGame {

    private final InputView inputView;

    public CarRacingGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void startGame() {
        GameStartParameter gameStartParameter = scanGameStartParameters();

        play(gameStartParameter);
    }

    void play(GameStartParameter gameStartParameter) {
        List<SimpleCar> cars = generateCars(gameStartParameter);
        runCars(gameStartParameter, cars);
    }

    List<SimpleCar> generateCars(GameStartParameter gameStartParameter) {
        return IntStream.range(0, gameStartParameter.getCarNums())
                .mapToObj(i -> new SimpleCar()).collect(Collectors.toList());
    }

    private void runCars(GameStartParameter gameStartParameter, List<SimpleCar> cars) {
        ResultView.printRunResultText();

        Stream.iterate(0, i -> i + 1)
                .limit(gameStartParameter.getRunNums())
                .forEach(i -> runCarsAndPrintState(cars));
    }

    private void runCarsAndPrintState(List<SimpleCar> cars) {
        cars.forEach(SimpleCar::run);
        ResultView.printCarsRunState(cars);
    }

    private GameStartParameter scanGameStartParameters() {
        InputView.printCarNumTakingView();
        int carNums = inputView.scanNextPositiveInteger().getIntValue();
        InputView.printTryNumView();
        int runNums = inputView.scanNextPositiveInteger().getIntValue();

        return new GameStartParameter(carNums, runNums);
    }
}
