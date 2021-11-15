package race;

import race.domain.*;
import race.view.inboud.InputView;
import race.view.outbound.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private final Collection<CarName> carNames;
    private final int numberOfMovement;
    private final OutputView outputView;
    private final MoveCars moveCars;
    private final FilterWinners filterWinners;

    public RacingGame(InputView inputView, OutputView outputView, MoveCars moveCars, FilterWinners filterWinners) {
        this(inputView.carNames(), inputView.numberOfMovement(), outputView, moveCars, filterWinners);
    }

    public RacingGame(Collection<CarName> carNames, int numberOfMovement, OutputView outputView, MoveCars moveCars, FilterWinners filterWinners) {
        if (carNames.size() <= 0 || numberOfMovement <= 0) {
            throw new IllegalArgumentException("numberOfCarNames and numberOfMovement must be positive");
        }

        this.carNames = carNames;
        this.numberOfMovement = numberOfMovement;
        this.outputView = outputView;
        this.moveCars = moveCars;
        this.filterWinners = filterWinners;
    }

    public void start() {
        Collection<Car> cars = setUpCars(carNames);

        for (int i = 0; i < numberOfMovement; i++) {
            moveCars.moveCars(cars);
            outputView.renderLocation(cars);
        }
        outputView.renderWinners(filterWinners.filter(cars));
    }

    private Collection<Car> setUpCars(Collection<CarName> carNames) {
        return Collections.unmodifiableCollection(
                carNames.stream().map(Car::new).collect(Collectors.toList())
        );
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
