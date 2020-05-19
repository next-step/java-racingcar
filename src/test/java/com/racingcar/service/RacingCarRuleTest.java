package com.racingcar.service;

import com.racingcar.model.RacingCar;
import com.racingcar.model.RacingCarGame;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RacingCarRuleTest {

    @DisplayName("자동차 경주에서 이동하는 규칙 중 4이상이 나오면 상태가 1 증가하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideRacingStatusValue")
    void defaultRacingCarRuleTest(final Integer racingStatusValue, final Boolean expected) {

        TestRacingCarRule rule = new TestRacingCarRule(racingStatusValue);
        Boolean isMoving = rule.isRacingCarMove();

        assertEquals(isMoving, expected);
    }

    private static Stream<Arguments> provideRacingStatusValue() {
        return Stream.of(
                Arguments.of(3, Boolean.FALSE),
                Arguments.of(5, Boolean.TRUE),
                Arguments.of(4, Boolean.TRUE)
        );
    }

    @DisplayName("랜덤 값이 0 - 9 사이로 나오는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = 10)
    void generateRandomRacingStatusValueTest(final Integer count) {

        RacingCarRule rule = new RacingCarRule();

        IntStream.range(0, count).forEach(i -> {
            Integer statusValue = rule.generateRandomRacingStatusValue();
            assertTrue(0 <= statusValue && statusValue < 10);
        });
    }

    private static class TestRacingCarRule extends RacingCarRule {

        private Integer racingStatus;

        TestRacingCarRule(Integer racingStatus) {
            this.racingStatus = racingStatus;
        }

        @Override
        protected Integer generateRandomRacingStatusValue() {
            return this.racingStatus;
        }
    }

    @DisplayName("우승자 테스트")
    @ParameterizedTest
    @MethodSource("provideRacingCarGame")
    void extractWinnerTest(final RacingCarGame racingCarGame, final List<RacingCar> expectedRacingCars) {
        List<RacingCar> winnerRacingCars = racingCarGame.extractWinner();

        assertEquals(winnerRacingCars.size(), expectedRacingCars.size());
        assertTrue(CollectionUtils.containsAll(winnerRacingCars, expectedRacingCars));
    }

    private static Stream<Arguments> provideRacingCarGame() {

        RacingCarGame racingCarGame1 = dummyRacingCarGame1();
        RacingCarGame racingCarGame2 = dummyRacingCarGame2();

        RacingCar racingCarGame1ExpectedWinner = racingCarGame1.getRacingCars().get(1);
        RacingCar racingCarGame2ExpectedWinner1 = racingCarGame2.getRacingCars().get(0);
        RacingCar racingCarGame2ExpectedWinner2 = racingCarGame2.getRacingCars().get(1);

        return Stream.of(
                Arguments.of(racingCarGame1, Collections.singletonList(racingCarGame1ExpectedWinner)),
                Arguments.of(racingCarGame2, Arrays.asList(racingCarGame2ExpectedWinner1, racingCarGame2ExpectedWinner2))
        );
    }

    private static RacingCarGame dummyRacingCarGame1() {
        Integer countOfAttempt = 5;
        RacingCarGame racingCarGame = new RacingCarGame(
                Arrays.asList("carA", "carB", "carC"), countOfAttempt
        );

        RacingCar carA = racingCarGame.getRacingCars().get(0);
        makeRacingCarStatusForRequirement(carA, countOfAttempt, 3);

        RacingCar carB = racingCarGame.getRacingCars().get(1);
        makeRacingCarStatusForRequirement(carB, countOfAttempt, 4);

        RacingCar carC = racingCarGame.getRacingCars().get(2);
        makeRacingCarStatusForRequirement(carC, countOfAttempt, 1);

        return racingCarGame;
    }

    private static RacingCarGame dummyRacingCarGame2() {
        Integer countOfAttempt = 3;
        RacingCarGame racingCarGame = new RacingCarGame(
                Arrays.asList("carA", "carB", "carC", "carD"), 3
        );

        RacingCar carA = racingCarGame.getRacingCars().get(0);
        makeRacingCarStatusForRequirement(carA, countOfAttempt, 3);

        RacingCar carB = racingCarGame.getRacingCars().get(1);
        makeRacingCarStatusForRequirement(carB, countOfAttempt, 3);

        RacingCar carC = racingCarGame.getRacingCars().get(2);
        makeRacingCarStatusForRequirement(carC, countOfAttempt, 2);

        RacingCar carD = racingCarGame.getRacingCars().get(3);
        makeRacingCarStatusForRequirement(carD, countOfAttempt, 1);

        return racingCarGame;
    }

    private static void makeRacingCarStatusForRequirement(RacingCar racingCar, Integer countOfAttempt, Integer expectedStatus) {
        TestRacingCarRule testRacingCarRule = new TestRacingCarRule(4);
        IntStream.range(0, countOfAttempt).forEach(i -> {
            if (racingCar.getRacingStatus().equals(expectedStatus)) {
                return;
            }

            racingCar.setRacingCarMoveStrategy(testRacingCarRule);
            racingCar.movingRacingCar();
        });
    }
}
