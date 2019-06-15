package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.StringUtils;

public class RacingGameStatus implements Visualizable {

    private final Participants participants;

    RacingGameStatus(final RacingGame racingGame) {
        this.participants = racingGame.getParticipants();
    }

    @Override
    public String visualize() {
        return getVisualGameStatus();
    }

    private String getVisualGameStatus() {
        final StringBuilder visualBuilder = new StringBuilder();

        for (final Car car : participants.list()) {
            final CarStatus status = car.getStatus();

            visualBuilder.append(status.visualize())
                    .append(StringUtils.NEW_LINE);
        }

        return visualBuilder.toString();
    }
}
