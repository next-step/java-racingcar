package com.mommoo.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    private static final String[] CAR_NAMES = {"pobi", "crong", "honux"};

    private RacingGame racingGame;

    @BeforeEach
    public void createInstance() {
        racingGame = new RacingGame(CAR_NAMES);
    }

    @DisplayName("자동차 주행 거리는 시행한 횟수 보다 같거나 작습니다.")
    @ParameterizedTest
    @ValueSource(ints={1, 2, 3})
    public void testMove(int time) {
        List<Integer> movePositions = racingGame.move()
                                                .stream()
                                                .map(Car::getPosition)
                                                .collect(Collectors.toList());
        for (int position : movePositions) {
            assertThat(position).isLessThan(time + 1);
        }
    }

    @DisplayName("올바른 자동차 상태 값이 저장된 리스트여야 합니다.")
    @ParameterizedTest
    @ValueSource(ints={1, 2, 3})
    public void testCurrentCarListIsValid(int time) {
        List<Car> movedCarList = racingGame.move();
        List<Car> currentCarList = racingGame.currentCarList();

        int size = movedCarList.size();

        for (int index = 0; index < size; index++) {
            Car movedCar = movedCarList.get(index);
            Car currentCar = currentCarList.get(index);
            assertThat(movedCar).isEqualTo(currentCar);
        }
    }
}
