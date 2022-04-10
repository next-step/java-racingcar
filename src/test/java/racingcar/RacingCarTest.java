package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 게임 테스트")
public class RacingCarTest {

    @Test
    @DisplayName("주어진 횟수는 0 이상이어야 한다.")
    void roundCountTest() {
        assertThatThrownBy(() -> new RacingCar(1, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("주어진 횟수는 0 이상이어야 합니다.");
    }

    @Test
    @DisplayName("사용자가 입력한 자동차는 1대 이상이어야 한다.")
    void carCountTest() {
        assertThatThrownBy(() -> new RacingCar(0, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 1대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("랜덤으로 생성한 값의 범위는 0~9이어야 한다.")
    void randomNumberTest() {
        RandomGenerator randomGenerator = new RandomGenerator();
        int number = randomGenerator.generate();
        assertThat(number).isGreaterThanOrEqualTo(0);
        assertThat(number).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("랜덤으로 생성한 값의 범위가 0~9가 아닐경우 에러가 발생한다.")
    void randomNumberFailTest() {
    }

    @Test
    @DisplayName("랜덤으로 생성한 값이 4 이상일 경우 전진해야한다.")
    void carMoveTest() {
        Car car = new Car(5);
    }

    @Test
    @DisplayName("자동차의 초기 상태는 0이어야 한다.")
    void carStateTest() {
        Car car = new Car(5);
        assertThat(car.getState()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    @DisplayName("자동차의 현재 상태는 주어진 횟수값을 넘을 수 없다.")
    void carStateFailTest(int count) {
        Car car = new Car(count);
        assertThatThrownBy(() -> {
            for (int i = 0; i<=count; i++){
                car.move();
            }
        })
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("자동차의 상태는 시도 횟수를 넘을 수 없습니다.");
    }
}
