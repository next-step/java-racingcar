package com.jaeyeonling.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

class Participants {

    private final List<Car> participants;

    Participants(final List<String> nameOfParticipants,
                 final MoveStrategy moveStrategy) {
        participants = nameOfParticipants.stream()
                .map(name -> new Car(name, moveStrategy))
                .collect(Collectors.toUnmodifiableList());
    }

    List<Car> getCars() {
        return participants;
    }
}
