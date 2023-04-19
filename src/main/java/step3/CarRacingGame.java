package step3;

import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    void runCars(GameStartParameter gameStartParameter, List<SimpleCar> cars) {
        ResultView.printRunResultText();

        for (int i = 0; i< gameStartParameter.getRunNums(); i++){
            cars.forEach(SimpleCar::run);
            ResultView.printCarsRunState(cars);
        }
    }

    GameStartParameter scanGameStartParameters() {
        InputView.printCarNumTakingView();
        int carNums = inputView.scanNextPositiveInteger().getIntValue();
        InputView.printTryNumView();
        int runNums = inputView.scanNextPositiveInteger().getIntValue();

        return new GameStartParameter(carNums, runNums);
    }
}
