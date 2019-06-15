package com.jaeyeonling.racingcar.domain;

import java.util.stream.IntStream;

class Participants {

    private static final int PARTICIPANTS_START_INCLUSIVE = 1;

    private final Car[] participants;

    Participants(final int numberOfParticipants) {
        participants = IntStream.rangeClosed(PARTICIPANTS_START_INCLUSIVE, numberOfParticipants)
                .mapToObj(i -> new Car())
                .toArray(Car[]::new);
    }

    Car[] list() {
        return participants;
    }
}
