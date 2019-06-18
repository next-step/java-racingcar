package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.StringUtils;
import com.jaeyeonling.racingcar.view.Visualizable;

import java.util.List;
import java.util.stream.Collectors;

class Participants implements Visualizable {

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

    @Override
    public String visualize() {
        return getVisualGameStatus();
    }

    private String getVisualGameStatus() {
        final StringBuilder visualBuilder = new StringBuilder();
        for (final Car car : getCars()) {
            visualBuilder.append(car.visualize())
                    .append(StringUtils.NEW_LINE);
        }

        return visualBuilder.toString();
    }

}
