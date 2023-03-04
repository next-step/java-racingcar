package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import service.RacingCarService;
import view.RacingCarView;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class RacingCarTest {

    RacingCarService racingCarService;

    static Stream<Arguments> provideCarNamesAndTargetDistance() {
        return Stream.of(
                Arguments.of("pobi,woni,jun", 5),
                Arguments.of("pobi", 5),
                Arguments.of("pobi,woni", 5));
    }

    @DisplayName("자동차 경주 테스트")
    @ParameterizedTest
    @MethodSource("provideCarNamesAndTargetDistance")
    void startRacing(String input, int targetDistance) {
        List<String> carNames = RacingCarView.getCarNames(input);

        racingCarService = new RacingCarService();
        racingCarService.startRacing(carNames, targetDistance);
    }

}
