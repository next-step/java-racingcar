package com.jaeyeonling.racingcar.domain;

import java.util.List;

public class RacingGameResult {

    private final List<Car> victors;

    RacingGameResult(final Participants participants) {
        victors = participants.getLeadingCars();
    }

    public List<Car> getVictors() {
        return victors;
    }
}
