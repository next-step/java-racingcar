package carRace.domain.RaceHost;

import carRace.domain.Referee.Referee;
import carRace.domain.car.CarGroup;
import carRace.domain.car.CarNames;
import carRace.domain.randomNumber.RandomNumber;
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

    public void playGame(final CarGroup carGroup) {
        for (int gameCount = 0; gameCount < raceTryCount; gameCount++) {
            moveCar(carGroup);
            OutputView.printRaceResult(carGroup);
        }
    }

    private void moveCar(final CarGroup carGroup) {
        List<CompletableFuture<Void>> runningCarGroup = carGroup.getCarGroup().stream()
            .map(car -> CompletableFuture.runAsync(
                () -> car.move(new RandomNumber(RandomNumberGenerator.createRandomNumber()))))
            .collect(Collectors.toList());

        waitCarGroup(runningCarGroup);
    }

    private void waitCarGroup(final List<CompletableFuture<Void>> runningCarGroup) {
        CompletableFuture<Void> waitCarGroup = CompletableFuture.allOf(
            runningCarGroup.toArray(new CompletableFuture[ZERO]));
        ranAllCarGroup(waitCarGroup);
    }

    private void ranAllCarGroup(final CompletableFuture<Void> waitCarGroup) {
        waitCarGroup.join();
    }

    public void progressAwardsCeremony(final CarGroup carGroup) {
        Referee referee = new Referee();
        CarNames winners = referee.findWinnersName(carGroup);
        OutputView.printWinnersResult(winners);
    }
}
