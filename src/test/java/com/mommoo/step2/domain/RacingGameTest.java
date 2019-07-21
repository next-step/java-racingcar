package com.mommoo.step2.domain;

import com.mommoo.step2.Car;
import com.mommoo.step2.domain.RacingGame;
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
        int drivenDistance = time + 1;

        assertThat(movePositions).allMatch(position -> position <= drivenDistance);
    }
}
