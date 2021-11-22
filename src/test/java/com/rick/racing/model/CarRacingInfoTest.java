package com.rick.racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingInfoTest {

    @Test
    @DisplayName("인스턴스 정상 생성 확인")
    public void create() {
        final List<String> carNames = Arrays.asList("rick", "morty", "beth");
        final int tryCount = 5;

        CarRacingInfo carRacingInfo = CarRacingInfo.create(carNames, tryCount);

        List<String> createdCarNames = carRacingInfo.getCarGroup()
            .getWinners()
            .stream()
            .map(Car::getName)
            .map(CarName::toString)
            .collect(Collectors.toList());

        assertThat(createdCarNames).containsExactlyElementsOf(carNames);
        assertThat(carRacingInfo.getTryCount()).isEqualTo(TryCount.create(tryCount));
    }
}