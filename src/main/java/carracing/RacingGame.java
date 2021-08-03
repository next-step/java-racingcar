package carracing;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.Position;
import carracing.domain.RandomNumberGenerator;
import carracing.view.InputView;
import carracing.view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int STARTING_LINE_POSITION = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(InputView inputView, OutputView outputView, RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void start() {
        Cars cars = Cars.of(getCars());
        race(cars, getMoveCount());
        outputView.printWinners(cars.getWinners());
    }

    private List<Car> getCars() {
        outputView.printCarNameInputMessage();
        return inputView.getCarNames()
                .stream()
                .map(carName -> Car.of(Position.of(STARTING_LINE_POSITION), carName))
                .collect(Collectors.toList());
    }

    private int getMoveCount() {
        outputView.printInputMoveCountMessage();
        return inputView.getMoveCount();
    }

    private void race(Cars cars, int moveCount) {
        outputView.printResultMessage();
        for (int i = 0; i < moveCount; ++i) {
            cars.move(randomNumberGenerator::generateRandomNumber);
            outputView.printPositions(cars);
            outputView.printNewLine();
        }
    }

    public static void main(String[] args) {
        try {
            InputView inputView = InputView.of(System.in);
            OutputView outputView = OutputView.of(System.out);
            RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.of(new Random());
            RacingGame racingGame = new RacingGame(inputView, outputView, randomNumberGenerator);
            racingGame.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
