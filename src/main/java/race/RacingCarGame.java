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

    public void notifyChampionWinner() {
        int largestMovement = findLargestMovement();
        List<RacingCar> winners = findWinners(largestMovement);
        resultView.printChampionWinner(winners);
    }

    private List<RacingCar> findWinners(int largestMovement) {
        return racingCars.stream()
                .filter(car -> car.checkSamePosition(largestMovement))
                .collect(Collectors.toList());
    }

    private int findLargestMovement() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }
}
