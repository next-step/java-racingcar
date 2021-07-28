package carracing;

import carracing.domain.*;
import carracing.view.InputView;
import carracing.view.OutputView;
import carracing.view.PositionRenderer;

import java.util.Random;

public class RacingGame {

    public static final int STARTING_LINE_POSITION = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(InputView inputView, OutputView outputView, RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void start() {
        outputView.printInputMoveCountMessage();
        int moveCount = inputView.getMoveCount();
        Car car = Car.of(STARTING_LINE_POSITION);
        outputView.printResultMessage();
        for (int i = 0; i < moveCount; ++i) {
            car.move(randomNumberGenerator.generateRandomNumber());
            outputView.printPosition(PositionRenderer.of(car.getPosition()));
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
