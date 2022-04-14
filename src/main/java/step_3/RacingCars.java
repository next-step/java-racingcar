package step_3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(int totalRounds, int totalRacingCarCount) {
        this.checkTotalRacingCarCount(totalRacingCarCount);
        this.racingCars = IntStream.range(0, totalRacingCarCount)
                .mapToObj(index -> new RacingCar(totalRounds))
                .collect(Collectors.toList());
    }

    public void roundFight(final int thisRound) {
        this.racingCars.forEach(racingCar -> racingCar.stopOrForward(thisRound));
    }

    public List<Integer> forwardHistoriesByRound() {
        return racingCars.stream()
                .map(RacingCar::forwardHistory)
                .collect(Collectors.toList());
    }

    public void checkTotalRacingCarCount(int totalRacingCarCount) {
        if (totalRacingCarCount < 1) {
            throw new IllegalArgumentException("참여하는 레이킹 카의 수는 1대 이상이어야 합니다.");
        }
    }
}
