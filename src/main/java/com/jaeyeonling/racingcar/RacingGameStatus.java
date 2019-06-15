package com.jaeyeonling.racingcar;

public class RacingGameStatus implements Visualizable {

    private static final String NEW_LINE = "\n";

    private final Car[] participants;

    RacingGameStatus(final RacingGame racingGame) {
        this.participants = racingGame.getParticipants();
    }

    @Override
    public String visualize() {
        return getVisualGameStatus();
    }

    private String getVisualGameStatus() {
        final StringBuilder visualBuilder = new StringBuilder();

        for (final Car car : participants) {
            final CarStatus status = car.getStatus();

            visualBuilder.append(status.visualize())
                    .append(NEW_LINE);
        }

        return visualBuilder.toString();
    }
}
