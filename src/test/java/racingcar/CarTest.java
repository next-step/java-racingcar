package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.RandomStrategy;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final Car car = new Car();
    private final RandomStrategy randomStrategy = new RandomStrategy();


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 전략을 이용한 자동차 전진 테스트")
    void moveTest(int value) {
        assertThat(car.moveOrStop(randomStrategy, value)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("랜덤 전략을 이용한 자동차 멈춤 테스트")
    void stopTest(int value) {
        assertThat(car.moveOrStop(randomStrategy, value)).isZero();
    }
}
