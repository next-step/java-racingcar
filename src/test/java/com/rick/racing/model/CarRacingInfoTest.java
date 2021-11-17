package com.rick.racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarRacingInfoTest {

    @Test
    @DisplayName("인스턴스 정상 생성 확인")
    public void create() {
        final List<String> carNames = Arrays.asList("rick", "morty", "beth");
        final int tryCount = 5;

        CarRacingInfo carRacingInfo = CarRacingInfo.create(carNames, tryCount);

        List<String> createdCarNames = carRacingInfo.cars()
            .stream()
            .map(Car::name)
            .map(CarName::toString)
            .collect(Collectors.toList());

        assertThat(createdCarNames).isEqualTo(carNames);
        assertThat(carRacingInfo.tryCount()).isEqualTo(tryCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1:carB", "3:2:carA", "3:3:carA,carB"}, delimiter = ':')
    @DisplayName("위치에 따른 우승자 조회 테스트")
    public void winnersTest(int carAPosition, int carBPosition, String expectedWinners) {
        final String nameOfCarA = "carA";
        final String nameOfCarB = "carB";
        final List<String> carNames = Arrays.asList(nameOfCarA, nameOfCarB);
        final int tryCount = 5;

        CarRacingInfo carRacingInfo = CarRacingInfo.create(carNames, tryCount);

        Optional<Car> carA = carRacingInfo.cars()
            .stream()
            .filter(car -> car.hasSameName(Car.create(nameOfCarA)))
            .findFirst();

        Optional<Car> carB = carRacingInfo.cars()
            .stream()
            .filter(car -> car.hasSameName(Car.create(nameOfCarB)))
            .findFirst();

        for (int i = 0; i < carAPosition; i++) {
            carA.ifPresent(Car::moveForward);
        }

        for (int i = 0; i < carBPosition; i++) {
            carB.ifPresent(Car::moveForward);
        }

        String winners = carRacingInfo.winners()
            .stream()
            .map(Car::name)
            .map(CarName::toString)
            .collect(Collectors.joining(","));

        assertThat(winners).isEqualTo(expectedWinners);
    }
}