package racing.board;

import racing.model.NamedRacingCar;
import racing.model.RacingCar;
import racing.supplier.BoundedRandomIntSupplier;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

public class RacingGameBoard {

    private static final int RANDOM_UPPER_BOUND = 10;

    private final List<RacingCar> cars;

    private IntSupplier intSupplier;

    public RacingGameBoard() {
        this(new BoundedRandomIntSupplier(RANDOM_UPPER_BOUND));
    }

    public RacingGameBoard(IntSupplier intSupplier) {
        cars = new ArrayList<>();
        this.intSupplier = intSupplier;
    }

    public int createCars(List<String> names) {
        cars.addAll(names.stream()
                .map(name -> new NamedRacingCar(name.trim()))
                .collect(Collectors.toList()));
        return cars.size();
    }

    public GameResult start(int timesOfMoves) {
        return runSteps(timesOfMoves);
    }

    private GameResult runSteps(int times) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < times; i++) {
            runStep();
            gameResult.addStep(cars);

        }
        return gameResult;
    }

    private void runStep() {
        for (RacingCar car : cars) {
            car.move(intSupplier.getAsInt());
        }
    }
}
