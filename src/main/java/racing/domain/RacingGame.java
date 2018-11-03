package racing.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RacingGame {
    private List<RacingCar> racingCars;
    private int totalTime;
    private int currentTime;

    public RacingGame(int racingCarNumber, int totalTime) {
        this.initRacingCars(racingCarNumber);
        this.totalTime = totalTime;
        this.currentTime = 0;
    }

    private void initRacingCars(int racingCarNumber) {
        // 레이싱카 리스트 초기화
        racingCars = IntStream.range(0, racingCarNumber)
                .mapToObj(i -> new RacingCar())
                .collect(toList());
    }

    public List<Integer> race() {
        currentTime += 1;
        return racingCars.stream()
                .peek(RacingCar::rush)
                .map(RacingCar::getPosition)
                .collect(toList());
    }

    public boolean isRacingAvailable() {
        return totalTime > currentTime;
    }
}
