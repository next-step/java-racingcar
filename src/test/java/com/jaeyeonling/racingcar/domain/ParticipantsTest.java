package com.jaeyeonling.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @DisplayName("Participants 생성")
    @Test
    void create() {
        final List<String> nameOfParticipants = Arrays.asList("a,b,c".split(","));
        final Participants participants = new Participants(nameOfParticipants, i -> true);

        assertThat(participants).isNotNull();
    }

    @DisplayName("1등하고 있는 리스트 조회")
    @Test
    void everyoneLeadingCars() {
        final List<String> nameOfParticipants = Arrays.asList("a,b,c".split(","));
        final Participants participants = new Participants(nameOfParticipants, i -> true);

        participants.getLeadingCars().forEach(car -> assertThat(nameOfParticipants).contains(car.getName()));
    }

    @DisplayName("1명 1등 조회")
    @Test
    void oneLeadingCars() {
        // given
        final MoveStrategy moveStrategy = i -> true;
        final List<String> nameOfParticipants = Arrays.asList("a,b,c".split(","));
        final Participants participants = new Participants(nameOfParticipants, moveStrategy);

        // when
        final Car victor = new Car("Victor", Car.DEFAULT_POSITION + 1, moveStrategy);
        participants.add(victor);

        // then
        assertThat(participants.getLeadingCars().size()).isEqualTo(1);
        assertThat(participants.getLeadingCars().get(0)).isEqualTo(victor);
    }

    @DisplayName("전체 차 이동")
    @Test
    void move() {
        final List<String> nameOfParticipants = Arrays.asList("a,b,c".split(","));
        final Participants participants = new Participants(nameOfParticipants, i -> true);

        participants.getLeadingCars().forEach(car -> car.isMatchPosition(Car.DEFAULT_POSITION));

        participants.move();

        participants.getLeadingCars().forEach(car -> car.isMatchPosition(Car.DEFAULT_POSITION + 1));
    }
}
