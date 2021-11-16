package race;

import race.domain.*;
import race.view.inboud.InputView;
import race.view.outbound.OutputView;

import java.util.*;

public class RacingGame {
    private final SetUpCars setUpCars;
    private final int numberOfMovement;
    private final OutputView outputView;
    private final MoveCars moveCars;
    private final FilterWinners filterWinners;

    public RacingGame(InputView inputView, OutputView outputView, MoveCars moveCars, FilterWinners filterWinners) {
        this(new SetUpCars(inputView.carNames()), inputView.numberOfMovement(), outputView, moveCars, filterWinners);
    }

    public RacingGame(SetUpCars setUpCars, int numberOfMovement, OutputView outputView, MoveCars moveCars, FilterWinners filterWinners) {
        if (numberOfMovement <= 0) {
            throw new IllegalArgumentException("numberOfMovement must be positive");
        }

        this.setUpCars = setUpCars;
        this.numberOfMovement = numberOfMovement;
        this.outputView = outputView;
        this.moveCars = moveCars;
        this.filterWinners = filterWinners;
    }

    public void start() {
        Collection<Car> cars = setUpCars.setUp();

        for (int i = 0; i < numberOfMovement; i++) {
            moveCars.moveCars(cars);
            outputView.renderLocation(cars);
        }
        outputView.renderWinners(filterWinners.filter(cars));
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoveCars moveCars = new MoveCars(new JudgeCarMovement(new Random()));
        FilterWinners filterWinners = new FilterWinners();

        new RacingGame(inputView, outputView, moveCars, filterWinners).start();

        inputView.close();
    }
}
