package race;

import race.inboud.InputView;
import race.outbound.OutputView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;

public class RacingGame {
    private final int numberOfCars;
    private final int numberOfMovement;
    private final OutputView outputView;
    private final MoveCars moveCars;

    public RacingGame(InputView inputView, OutputView outputView, MoveCars moveCars) {
        this(inputView.numberOfCars(), inputView.numberOfMovement(), outputView, moveCars);
    }

    public RacingGame(int numberOfCars, int numberOfMovement, OutputView outputView, MoveCars moveCars) {
        if (numberOfCars <= 0 || numberOfMovement <= 0) {
            throw new IllegalArgumentException("numberOfCars and numberOfMovement must be positive");
        }

        this.numberOfCars = numberOfCars;
        this.numberOfMovement = numberOfMovement;
        this.outputView = outputView;
        this.moveCars = moveCars;
    }

    public void start() {
        Collection<Car> cars = setUpCars(numberOfCars);

        for (int i = 0; i < numberOfMovement; i++) {
            moveCars.moveCars(cars);
            outputView.render(cars);
        }
    }

    private Collection<Car> setUpCars(int numberOfCars) {
        Collection<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            // TODO: 이름 입력받도록하기
            cars.add(new Car(new CarName(UUID.randomUUID().toString().substring(0, 3))));
        }
        return cars;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoveCars moveCars = new MoveCars(new JudgeCarMovement(new Random()));

        new RacingGame(inputView, outputView, moveCars).start();

        inputView.close();
    }
}
