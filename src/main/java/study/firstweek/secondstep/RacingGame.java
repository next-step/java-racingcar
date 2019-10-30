package study.firstweek.secondstep;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final List<RacingCar> cars;
    private int trial;
    private final NumberGenerator generator = new NumberGenerator();


    public RacingGame(int carCount, int trialCount) {
        cars = IntStream.range(0, carCount).mapToObj(i -> new RacingCar())
            .collect(Collectors.toList());
        trial = trialCount;
    }

    public List<RacingResult> startGame() {
        IntStream.range(0, trial)
            .forEach(i -> moveCars());

        return getRacingGameResults();
    }

    private List<RacingResult> getRacingGameResults() {
        return cars.stream().map(car -> new RacingResult(car.getStepHistory())).collect(Collectors.toList());
    }

    private void moveCars() {
        cars.forEach(car -> car.makeCarMove(generator.getRandomNumber()));
    }
}
