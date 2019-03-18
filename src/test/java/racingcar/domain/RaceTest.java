package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.junit.Test;

public class RaceTest {

    @Test
    public void test_play() throws CloneNotSupportedException {
        // Given
        final List<RacingCar> cars = Arrays.asList(
                new RacingCar("pobi", 2),
                new RacingCar("honux", 1),
                new RacingCar("crong", 5));

        final List<RacingCar> copyCars1 = new ArrayList<>(cars.size());

        for (RacingCar car : cars) {
            copyCars1.add((RacingCar) car.clone());
        }

        // When
        Race race = new Race(cars);
        final List<RacingCar> playedCars = race.play().getCars();

        // Then
        for (int i = 0; i < cars.size(); i++) {
            assertThat(copyCars1.get(i).compareTo(playedCars.get(i))).isNotEqualTo(1);
        }
    }

    @Test
    public void 우승자_한명_구하기() {
        // Given
        final RacingCar winner = new RacingCar("crong", 5);
        final List<RacingCar> cars = Arrays.asList(
                new RacingCar("pobi", 2),
                new RacingCar("honux", 1),
                winner);

        Race race = new Race(cars);

        // When
        List<RacingCar> winners = race.getWinners();

        // Then
        assertThat(winners.get(0)).isEqualTo(winner);
    }

    @Test
    public void 우승자_두명이상_구하기() {
        // Given
        final RacingCar winner1 = new RacingCar("winner1", 5);
        final RacingCar winner2 = new RacingCar("winner2", 5);

        final List<RacingCar> cars = Arrays.asList(
                new RacingCar("pobi", 2), new RacingCar("honux", 1),
                winner1, winner2);

        Race race = new Race(cars);

        // When
        List<RacingCar> winners = race.getWinners();

        // Then
        assertThat(winners).contains(winner1, winner2);
    }
}