package step3.domain;

import step3.movingstrategy.MovingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Contest {
    private final int round;
    private final List<Car> participants;
    private final MovingStrategy movingStrategy;
    private final ReportingLocation reporter;

    public Contest(
            int round,
            List<Car> participants,
            MovingStrategy movingStrategy,
            ReportingLocation reporter
    ) {
        this.reporter = reporter;
        assert participants != null;
        assert movingStrategy != null;
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
        return participants.stream()
                .map(p -> p.play(movingStrategy))
                .collect(Collectors.toList());
    }

    public interface ReportingLocation {
        void report(List<Location> locations);
    }
}
