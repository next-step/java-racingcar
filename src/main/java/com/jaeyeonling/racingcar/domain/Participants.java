package com.jaeyeonling.racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Participants {

    private static final int PARTICIPANTS_START_INCLUSIVE = 1;

    private final List<Car> participants;

    Participants(final int numberOfParticipants,
                 final MoveStrategy moveStrategy) {
        participants = IntStream.rangeClosed(PARTICIPANTS_START_INCLUSIVE, numberOfParticipants)
                .mapToObj(i -> new Car(moveStrategy))
                .collect(Collectors.toList());
    }

    List<Car> toList() {
        return Collections.unmodifiableList(participants);
    }
}
