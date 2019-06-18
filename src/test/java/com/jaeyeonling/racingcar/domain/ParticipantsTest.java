package com.jaeyeonling.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    void leadingCars() {
        final List<String> nameOfParticipants = Arrays.asList("a,b,c".split(","));
        final Participants participants = new Participants(nameOfParticipants, i -> true);

        participants.getLeadingCars().forEach(car -> assertThat(nameOfParticipants).contains(car.getName()));
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
