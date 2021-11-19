package step3.domain.entity;

import step3.domain.movingstrategy.MovingStrategy;
import step3.domain.value.Location;

import java.util.List;
import java.util.stream.Collectors;

public class Contest {
    private final int round;
    private final Participants participants;
    private final MovingStrategy movingStrategy;
    private final ReportingLocation reporter;

    public Contest(
            int round,
            Participants participants,
            MovingStrategy movingStrategy,
            ReportingLocation reporter
    ) {
        this.reporter = reporter;
        assertNull(participants, movingStrategy);
        this.round = round;
        this.participants = participants;
        this.movingStrategy = movingStrategy;
    }

    public void play() {
        for (int i = 0; round > i; i++) {
            List<Location> locations = playEachRound();
            reporter.report(locations);
        }
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
}
