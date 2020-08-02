package step3;

import step3.collections.AttemptResult;
import step3.collections.RacePlayers;
import step3.collections.RaceResult;
import step3.dto.ParticipationForm;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ControlTower {

    private final Integer attemptCount;

    private final RacePlayers racePlayers;

    public ControlTower(ParticipationForm participationForm) {
        this.attemptCount = participationForm.getAttemptCount();
        this.racePlayers = new RacePlayers(participationForm.getParticipationCount());
    }

    public RaceResult startCarRacing() {
        return new RaceResult(run(this.racePlayers));
    }

    private List<AttemptResult> run(RacePlayers racePlayers) {
        return IntStream.range(0,this.attemptCount)
                        .mapToObj(index -> racePlayers.attempt())
                        .collect(Collectors.toList());

    }
}
