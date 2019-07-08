package racing.domain;

import racing.domain.strategy.DrivingRandomStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private Cars cars;

    public RacingGame(List<String> carNames) {
        this.cars = new Cars(carNames);
    }

    public RacingGameResult startRacing(int moves) {
        List<TrackResult> trackResults = IntStream.range(0, moves)
                .mapToObj(i -> cars.go(new DrivingRandomStrategy()))
                .collect(Collectors.toList());

        return new RacingGameResult(trackResults, new WinnerMaker(cars).getWinners());
    }

    public int getNumOfCars() {
        return cars.size();
    }
}