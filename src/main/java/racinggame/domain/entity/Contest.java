package racinggame.domain.entity;

import racinggame.domain.movingstrategy.MovingStrategy;
import racinggame.domain.value.Location;

import java.util.Collections;
import java.util.List;

public class Contest {
    private final int round;
    private final Participants participants;
    private final MovingStrategy movingStrategy;
    private final Car.ReportingCar carReporter;
    private final ReportingWinner winnerReporter;

    public Contest(
            int round,
            Participants participants,
            MovingStrategy movingStrategy,
            Car.ReportingCar carReporter,
            ReportingWinner winnerReporter) {
        this.carReporter = carReporter;
        this.winnerReporter = winnerReporter;
        assertNull(participants, movingStrategy);
        this.round = round;
        this.participants = participants;
        this.movingStrategy = movingStrategy;
    }

    public void play() {
        List<Location> lastLocations = Collections.emptyList();
        for (int i = 0; round > i; i++) {
            lastLocations = playEachRound();
        }
        winnerReporter.report(participants);
    }

    private List<Location> playEachRound() {
        List<Location> results = participants.play(movingStrategy);
        participants.reportCurrentStatus(carReporter);
        return results;
    }

    private void assertNull(Participants participants, MovingStrategy movingStrategy) {
        if (participants == null) {
            throw new IllegalArgumentException("참가자는 null일 수 없습니다.");
        }
        if (movingStrategy == null) {
            throw new IllegalArgumentException("MovingStrategy는 null일 수 없습니다.");
        }
    }

    public interface ReportingWinner {
        void report(Participants participants);
    }
}
