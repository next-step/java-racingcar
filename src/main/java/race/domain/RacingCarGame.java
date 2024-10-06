package race.domain;

import race.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final ResultView resultView = new ResultView();
    private final List<RacingCar> racingCars;
    private final RaceCount raceCount;
    private final static int RANDOM_NUMBER_LIMIT = 10;
    private final NumberPicker numberPicker = new NumberPicker();

    public RacingCarGame(List<String> carNames, int raceCount) {
        this.racingCars = carNames.stream().map(RacingCar::new).collect(Collectors.toUnmodifiableList());
        this.raceCount = new RaceCount(raceCount);
    }

    public RacingCarGame(List<RacingCar> racingCars) {
        this.racingCars = List.copyOf(racingCars);
        this.raceCount = new RaceCount();
    }

    public void startRace() {
        resultView.printRaceStartMessage();
        while (raceCount.hasMoreRaces()) {
            race();
            raceCount.decrease();
        }

    }

    private void race() {
        for (RacingCar car : racingCars) {
            car.moveForward(numberPicker.generateRandomNumber(RANDOM_NUMBER_LIMIT));
        }
        resultView.printRaceCondition(racingCars);
    }

    public void notifyChampionWinner(List<RacingCar> winners) {
        resultView.printChampionWinner(winners);
    }

    public List<RacingCar> findWinners() {
        int largestMovement = findLargestMovement();
        return racingCars.stream()
                .filter(car -> car.hasSamePosition(largestMovement))
                .collect(Collectors.toList());
    }

    private int findLargestMovement() {
        int maxValue = 0;

        for (RacingCar racingCar : racingCars) {
            maxValue = racingCar.findMaxValue(maxValue);
        }
        return maxValue;
    }

}
