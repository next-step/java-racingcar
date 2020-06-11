package autoracing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String BAD_TOTAL_ROUNDS = "total rounds must be greater than zero.";
    private static final String NULL_PARTICIPANTS = "participants must not be null.";
    private static final String BAD_PARTICIPANTS = "the number of participants must be greater than zero.";

    private final int totalRounds;
    private final List<Car> participants;

    public RacingGame(int totalRounds, List<Car> participants) {
        if (totalRounds < 1) {
            throw new IllegalArgumentException(BAD_TOTAL_ROUNDS);
        }
        if (participants == null) {
            throw new NullPointerException(NULL_PARTICIPANTS);
        }
        if (participants.isEmpty()) {
            throw new IllegalArgumentException(BAD_PARTICIPANTS);
        }

        this.totalRounds = totalRounds;
        this.participants = participants;
    }

    public void setRule(RacingRule rule) {
        participants.forEach(participant -> participant.setRule(rule));
    }

    public void start() {
        for (int currentRounds = 0; currentRounds < totalRounds; currentRounds++) {
            participants.forEach(Car::race);
        }
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public List<Car> getWinners() {
        int winnerDistance = getWinnerDistance();
        return participants.stream()
                .filter((car) -> car.getLocation(totalRounds).getDistance() == winnerDistance)
                .collect(Collectors.toList());
    }

    private int getWinnerDistance() {
        return participants.stream()
                .map(car -> car.getLocation(totalRounds).getDistance())
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(BAD_PARTICIPANTS));
    }
}
