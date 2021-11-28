package carracing;

import carracing.cars.CarName;
import carracing.cars.StepForwardStrategy;
import carracing.cars.Track;
import carracing.rounds.Round;
import carracing.rounds.Rounds;

import java.util.List;

public class CarRace {
    private final Track track;
    private final int numberOfRounds;
    private final StepForwardStrategy stepForwardStrategy;
    private final Rounds rounds;
    private boolean finish;

    public CarRace(List<CarName> participantCarNames, int numberOfRounds, StepForwardStrategy stepForwardStrategy) {
        this.track = new Track(participantCarNames);
        this.numberOfRounds = numberOfRounds;
        this.stepForwardStrategy = stepForwardStrategy;

        this.rounds = new Rounds();
        this.finish = false;
    }

    public Rounds race() {
        if (finish) {
            throw new IllegalStateException("Race already done");
        }

        for (int i = 0; i < numberOfRounds; i++) {
            Round currentRound = track.forward(stepForwardStrategy);
            rounds.add(currentRound);
        }

        finish = true;
        return rounds;
    }
}
