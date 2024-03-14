package racingcar.domain;

import racingcar.domain.strategyPattern.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {
    private int trialCount;
    private List<Car> carList;
    private List<List<Car>> roundResults;

    public RacingCarGame(int carCount, int trialCount) {
        this.carList = createCarList(carCount);
        this.roundResults = new ArrayList<>();
        this.trialCount = trialCount;
    }

    public static List<Car> createCarList(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    public List<List<Car>> playRounds(int trialCount, MoveStrategy moveStrategy) {
        while (trialCount-- > 0) {
            play(moveStrategy);
            this.roundResults.add(new ArrayList<>(carList));
        }
        return roundResults;
    }

    public void play(MoveStrategy moveStrategy) {
        for (Car car : carList) {
            car.moveForward(moveStrategy);
        }
    }

    public List<List<Car>> getRoundResults() {
        return this.roundResults;
    }
}
