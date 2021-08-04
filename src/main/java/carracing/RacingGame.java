package carracing;

import carracing.domain.*;
import carracing.view.InputView;
import carracing.view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int STARTING_LINE_POSITION = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private final MoveStrategy moveStrategy;

    public RacingGame(InputView inputView, OutputView outputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        RacingCars racingCars = RacingCars.of(getCars());
        race(racingCars, getMoveCount());
        outputView.printWinners(racingCars.getWinners());
    }

    private List<RacingCar> getCars() {
        outputView.printCarNameInputMessage();
        return inputView.getCarNames()
                .stream()
                .map(carName -> RacingCar.of(Position.of(STARTING_LINE_POSITION), carName))
                .collect(Collectors.toList());
    }

    private int getMoveCount() {
        outputView.printInputMoveCountMessage();
        return inputView.getMoveCount();
    }

    private void race(RacingCars racingCars, int moveCount) {
        outputView.printResultMessage();
        for (int i = 0; i < moveCount; ++i) {
            racingCars.forEach(car -> car.move(moveStrategy));
            outputView.printPositions(racingCars);
            outputView.printNewLine();
        }
    }

    public static void main(String[] args) {
        try {
            InputView inputView = InputView.of(System.in);
            OutputView outputView = OutputView.of(System.out);
            MoveStrategy moveStrategy = RandomMoveStrategy.of(new Random());
            RacingGame racingGame = new RacingGame(inputView, outputView, moveStrategy);
            racingGame.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
