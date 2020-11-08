package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import racingcar.behavior.RandomMovingStrategy;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RacingTest {
    private static final int DEFAULT_DISTANCE = 0;
    private static final int MOVE = 1;
    private static final int NOT_MOVE = 0;

    @DisplayName("게임에 필요한 Car 를 생성자의 인자로 받아 원하는 인자를 가진 Car로 생성 여부")
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void create(final int value) {
        assertThatCode(() -> RacingCars.of(value, new RandomMovingStrategy())).doesNotThrowAnyException();
    }

    @DisplayName("초기화된 Cars의 위치가 시작점 0인 경우")
    @Test
    void initialCars() {
        RacingCars racing = RacingCars.of(3, new RandomMovingStrategy());
        assertThat(racing.getCars()
                .stream()
                .map(Car::getPosition)).contains(DEFAULT_DISTANCE);
    }


    @DisplayName("입력한 Car의 수와 생성된 Cars의 사이즈 일치 여부 (of 메소드) ")
    @Test
    void initialCarsSize() {
        List<Car> cars = RacingCars.of(3, new RandomMovingStrategy()).getCars();
        assertThat(cars).hasSize(3);
    }

    @DisplayName("게임을 한 번 수행할 때마다 만들어진 Car 는 이동 또는 정지 여부")
    @ParameterizedTest
    @MethodSource("moveCarsCase")
    void moveOrStopCar(boolean moveOrNot, int distance) {
        RacingCars racingCars = RacingCars.of(5, () -> moveOrNot);
        racingCars.run();
        assertThat(racingCars.getCars()
                .stream().map(Car::getPosition)).containsOnly(distance);
    }

    private static Stream<Arguments> moveCarsCase() {
        return Stream.of(
                Arguments.of(true, MOVE),
                Arguments.of(false, NOT_MOVE)
        );
    }
}
