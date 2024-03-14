package carRace.domain;

import carRace.util.RandomNumberGenerator;
import carRace.view.OutputView;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class RaceHost {

    private static final int ZERO = 0;

    private final int raceTryCount;

    public RaceHost(final int raceTryCount) {
        this.raceTryCount = raceTryCount;
    }

    public void playGame(final List<Car> cars) {
        for (int gameCount = 0; gameCount < raceTryCount; gameCount++) {
            moveCar(cars);
            OutputView.printRaceResult(cars);
        }
    }

    private void moveCar(final List<Car> cars) {
        List<CompletableFuture<Void>> runningCars = cars.stream()
            .map(car -> CompletableFuture.runAsync(() -> car.move(RandomNumberGenerator.createRandomNumber())))
            .collect(Collectors.toList());

        waitCars(runningCars);
    }

    private void waitCars(final List<CompletableFuture<Void>> runningCars) {
        CompletableFuture<Void> waitCars = CompletableFuture.allOf(
            runningCars.toArray(new CompletableFuture[ZERO]));
        ranAllCars(waitCars);
    }

    private void ranAllCars(final CompletableFuture<Void> waitCars) {
        waitCars.join();
    }
}
