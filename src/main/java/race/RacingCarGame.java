package race;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {
    private final ResultView resultView = new ResultView();
    private final List<RacingCar> racingCars;
    private final int raceCount;

    public RacingCarGame(List<String> carNames, int raceCount) {
        this.racingCars = carNames.stream().map(RacingCar::new).collect(Collectors.toUnmodifiableList());
        this.raceCount = raceCount;
    }

    public RacingCarGame(List<RacingCar> racingCars) {
        this.racingCars = List.copyOf(racingCars);
        this.raceCount = 1;
    }

    public void startRace() {
        System.out.println("실행 결과");
        IntStream.range(0, raceCount).forEach(i -> race(this.racingCars));
    }

    private void race(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            car.moveForward();
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
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }
}
