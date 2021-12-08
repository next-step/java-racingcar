package racinggame.domain.entity;

import racinggame.domain.movingstrategy.MovingStrategy;
import racinggame.domain.value.Location;

import java.util.Collections;
import java.util.List;

public class Contest {
    private final int round;
    private final Participants participants;
    private final MovingStrategy movingStrategy;
    private final ReportingLocation locationReporter;
    private final ReportingWinner winnerReporter;

    public Contest(
            int round,
            Participants participants,
            MovingStrategy movingStrategy,
            ReportingLocation locationReporter,
            ReportingWinner winnerReporter) {
        this.locationReporter = locationReporter;
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
            locationReporter.report(lastLocations);
        }
        winnerReporter.report(lastLocations);
    }

    private List<Location> playEachRound() {
        return participants.play(movingStrategy);
    }

    private void assertNull(Participants participants, MovingStrategy movingStrategy) {
        if (participants == null) {
            throw new IllegalArgumentException("참가자는 null일 수 없습니다.");
        }
        if (movingStrategy == null) {
            throw new IllegalArgumentException("MovingStrategy는 null일 수 없습니다.");
        }
    }

    public interface ReportingLocation {
        void report(List<Location> locations);
    }

    public interface ReportingWinner {
        void report(List<Location> locations);
    }
}
