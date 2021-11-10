package race;

import race.inboud.InputView;
import race.outbound.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private final Collection<CarName> carNames;
    private final int numberOfMovement;
    private final OutputView outputView;
    private final MoveCars moveCars;

    public RacingGame(InputView inputView, OutputView outputView, MoveCars moveCars) {
        this(inputView.carNames(), inputView.numberOfMovement(), outputView, moveCars);
    }

    public RacingGame(Collection<CarName> carNames, int numberOfMovement, OutputView outputView, MoveCars moveCars) {
        if (carNames.size() <= 0 || numberOfMovement <= 0) {
            throw new IllegalArgumentException("numberOfCarNames and numberOfMovement must be positive");
        }

        this.carNames = carNames;
        this.numberOfMovement = numberOfMovement;
        this.outputView = outputView;
        this.moveCars = moveCars;
    }

    public void start() {
        Collection<Car> cars = setUpCars(carNames);

        for (int i = 0; i < numberOfMovement; i++) {
            moveCars.moveCars(cars);
            outputView.render(cars);
        }
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

        new RacingGame(inputView, outputView, moveCars).start();

        inputView.close();
    }
}
