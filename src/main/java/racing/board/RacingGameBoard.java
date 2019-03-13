package racing.board;

import racing.supplier.BoundedIntSupplier;
import racing.model.NamedRacingCar;
import racing.model.RacingCar;
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
        this(new BoundedIntSupplier(RANDOM_UPPER_BOUND));
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
        ResultView.viewGameStart();
        return runSteps(timesOfMoves);
    }

    private GameResult runSteps(int times) {
        runUntilBeforeLastStep(times);
        return runLastStep();
    }

    private GameResult runLastStep() {
        List<Integer> positions = runStep();
        return new GameResult(cars, GameResult.maxPosition(positions));
    }

    private void runUntilBeforeLastStep(int lastStep) {
        for (int i = 0; i < lastStep - 1; i++) {
            runStep();
        }
    }

    private List<Integer> runStep() {
        List<Integer> positions = moveCars();
        ResultView.viewEndingOfStep();
        return positions;
    }

    private List<Integer> moveCars() {
        List<Integer> positions = new ArrayList<>();

        for (RacingCar car : cars) {
            int position = car.move(intSupplier.getAsInt());
            ResultView.viewRunningStep(car.toString(), position);

            positions.add(position);
        }

        return positions;
    }
}
