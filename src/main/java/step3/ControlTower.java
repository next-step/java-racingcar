package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ControlTower {

    private Integer attemptCount;

    public RaceResult startCarRacing(ParticipationForm participationForm) {
        this.attemptCount = participationForm.getAttemptCount();
        RaceCondition raceCondition = prepareRaceCondition(participationForm.getParticipationCount());
        return new RaceResult(run(raceCondition));
    }

    List<AttemptResult> run(RaceCondition raceCondition) {
        return IntStream.range(0,this.attemptCount)
                        .mapToObj(index -> raceCondition.attempt())
                        .collect(Collectors.toList());

    }
    private RaceCondition prepareRaceCondition(Integer participationCount) {
        return new RaceCondition(participationCount);
    }



}
