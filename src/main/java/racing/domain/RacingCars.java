package racing.domain;

import racing.model.RoundResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(String[] names) {
        this.checkParticipantsCount(names.length);
        this.racingCars = Arrays.stream(names)
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public RoundResult roundFight() {
        return this.racingCars
                .stream()
                .collect(RoundResult::new, RoundResult::record, RoundResult::combined);

    }

    private void checkParticipantsCount(int totalRacingCarCount) {
        if (totalRacingCarCount < 1) {
            throw new IllegalArgumentException("참여하는 레이킹 카의 수는 1대 이상이어야 합니다.");
        }
    }
}
