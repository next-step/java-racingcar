package step3;

import step3.collections.AttemptResult;
import step3.collections.RacingCars;
import step3.collections.RaceResult;
import step3.dto.ParticipationForm;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ControlTower {

    private final int attemptCount;

    private final RacingCars racingCars;

    public ControlTower(ParticipationForm participationForm) {
        this.attemptCount = participationForm.getAttemptCount();
        this.racingCars = new RacingCars(participationForm.getParticipationCount());
    }

    public RaceResult startCarRacing() {
        return new RaceResult(run(this.racingCars));
    }

    private List<AttemptResult> run(RacingCars racingCars) {
        return IntStream.range(0,this.attemptCount)
                        .mapToObj(index -> racingCars.attempt())
                        .collect(Collectors.toList());

    }
}
