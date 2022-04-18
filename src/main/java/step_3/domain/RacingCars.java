package step_3.domain;

import step_3.model.RoundResult;
import step_3.util.Behavior;
import step_3.util.Roulette;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(int totalRacingCarCount) {
        this.hasRacingCar(totalRacingCarCount);
        this.racingCars = Stream.generate(RacingCar::new)
                .limit(totalRacingCarCount)
                .collect(Collectors.toList());
    }

    public RoundResult roundFight() {
        return this.racingCars
                .stream()
                .collect(RoundResult::new,
                        (roundResult, racingCar) -> {
                            String racingCarId = racingCar.getId();
                            Behavior behavior = racingCar.stopOrForward(Roulette.spin());
                            roundResult.record(racingCarId, behavior);
                        },
                        RoundResult::record);

    }

    private void hasRacingCar(int totalRacingCarCount) {
        if (totalRacingCarCount < 1) {
            throw new IllegalArgumentException("참여하는 레이킹 카의 수는 1대 이상이어야 합니다.");
        }
    }
}
