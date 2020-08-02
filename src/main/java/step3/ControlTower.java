package step3;

import step3.collections.AttemptResult;
import step3.collections.RacePlayers;
import step3.collections.RaceResult;
import step3.dto.ParticipationForm;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ControlTower {

    private Integer attemptCount;

    public RaceResult startCarRacing(ParticipationForm participationForm) {
        this.attemptCount = participationForm.getAttemptCount();
        RacePlayers racePlayers = prepareRaceCondition(participationForm.getParticipationCount());
        return new RaceResult(run(racePlayers));
    }

    List<AttemptResult> run(RacePlayers racePlayers) {
        return IntStream.range(0,this.attemptCount)
                        .mapToObj(index -> racePlayers.attempt())
                        .collect(Collectors.toList());

    }
    private RacePlayers prepareRaceCondition(Integer participationCount) {
        return new RacePlayers(participationCount);
    }



}
