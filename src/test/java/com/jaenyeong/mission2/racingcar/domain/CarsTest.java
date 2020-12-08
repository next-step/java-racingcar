package com.jaenyeong.mission2.racingcar.domain;

import com.jaenyeong.mission2.racingcar.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("여러 차를 그룹화한 Cars 클래스 테스트")
class CarsTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("countAndValidName")
    @DisplayName("Cars 객체 초기화 시 주어진 숫자만큼 Car 객체가 생성되는지 확인하는 테스트")
    void carsInitWhenGivenTheNumberOfCars(final int randomValue, final List<String> names) {
        final Cars cars = new Cars(names);

        assertEquals(cars.getHowManyRacingCars(), randomValue);
    }

    @ParameterizedTest
    @MethodSource("countAndValidName")
    @DisplayName("Cars 객체의 moveRacingCars 메서드 호출시 각 Car 객체들의 이동 거리 확인 테스트")
    void checkMoveOfCars(final int randomValue, final List<String> names) {
        final Cars cars = new Cars(names);

        moveCars(randomValue, cars);

        final List<Integer> distanceOfCars = cars.getDistanceRacingCars();

        distanceOfCars.forEach(distOfCar -> {
            final int start = 0;
            assertThat(distOfCar).isBetween(start, randomValue);
        });
    }

    @ParameterizedTest
    @MethodSource("countAndValidName")
    @DisplayName("Cars의 속한 모든 Car 객체의 이동 거리 기록 유효성 테스트")
    void checkAllRacingHistoriesForAllCars(final int randomValue, final List<String> names) {
        final Cars cars = new Cars(names);

        moveCars(randomValue, cars);

        final int start = 0;
        for (int distance : cars.getDistanceRacingCars()) {
            assertThat(distance).isBetween(start, randomValue);
        }
    }

    @ParameterizedTest
    @MethodSource("countAndValidName")
    @DisplayName("Cars의 속한 모든 Car 객체의 이동 거리를 비교하여 올바른 우승자를 반환하는지 테스트")
    void checkWinner(final int randomValue, final List<String> name) {
        final Cars cars = new Cars(name);

        moveCars(randomValue, cars);

        final int winDist = cars.getWinDistance();
        final Map<String, List<Integer>> histories = cars.getRaceHistoriesForAllCars();

        final List<String> winnerNames = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> history : histories.entrySet()) {
            final int lastDist = history.getValue().get(randomValue - 1);
            if (lastDist == winDist) {
                winnerNames.add(history.getKey());
            }
        }

        assertTrue(winnerNames.containsAll(cars.getWinners()));
    }

    private void moveCars(int randomValue, Cars cars) {
        for (int i = 0; i < randomValue; i++) {
            cars.moveRacingCars();
        }
    }
}
