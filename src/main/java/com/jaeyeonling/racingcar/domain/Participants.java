package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.RandomUtils;
import com.jaeyeonling.racingcar.utils.StringUtils;
import com.jaeyeonling.racingcar.view.Visualizable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Participants implements Visualizable {

    private final List<Car> participants = new ArrayList<>();

    Participants(final List<String> nameOfParticipants,
                 final MoveStrategy moveStrategy) {
        nameOfParticipants.stream()
                .map(name -> new Car(name, moveStrategy))
                .forEach(this::add);
    }

    @Override
    public String visualize() {
        return getVisualGameStatus();
    }

    List<Car> getLeadingCars() {
        final int leaderPosition = maxPosition();

        return participants.stream()
                .filter(car -> car.isMatchPosition(leaderPosition))
                .collect(Collectors.toUnmodifiableList());
    }

    void move() {
        participants.forEach(this::move);
    }

    void add(final Car car) {
        participants.add(car);
    }

    private String getVisualGameStatus() {
        final StringBuilder visualBuilder = new StringBuilder();
        for (final Car car : participants) {
            visualBuilder.append(car.visualize())
                    .append(StringUtils.NEW_LINE);
        }

        return visualBuilder.toString();
    }

    private int maxPosition() {
        return participants.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.DEFAULT_POSITION);
    }

    private void move(final Car car) {
        final int condition = RandomUtils.getIntWithBound(RacingGame.MOVING_RANDOM_BOUND);
        car.moveForward(condition);
    }
}
