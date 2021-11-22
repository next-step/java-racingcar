package com.rick.racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarGroupTest {

    @ParameterizedTest
    @CsvSource(value = {"0:1:carB", "3:2:carA", "3:3:carA,carB"}, delimiter = ':')
    @DisplayName("위치에 따른 우승자 조회 테스트")
    public void winnersTest(int positionOfCarA, int positionOfCarB, String expectedWinners) {
        final String nameOfCarA = "carA";
        final String nameOfCarB = "carB";
        List<Car> cars = Arrays.asList(
            Car.create(nameOfCarA, positionOfCarA),
            Car.create(nameOfCarB, positionOfCarB));

        CarGroup carGroup = CarGroup.create(cars);

        String winners = carGroup.getWinners()
            .stream()
            .map(Car::getName)
            .map(CarName::toString)
            .collect(Collectors.joining(","));

        assertThat(winners).isEqualTo(expectedWinners);
    }
}
