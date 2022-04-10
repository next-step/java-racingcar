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
    @DisplayName("자동차의 초기 상태는 0이어야 한다.")
    void carStateTest() {
        Car car = new Car(5);
        assertThat(car.state()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    @DisplayName("자동차의 현재 상태는 주어진 횟수값을 넘지 않는다.")
    void carStateFailTest(int count) {
        Car car = new Car(count);
        for (int i = 0; i<count; i++){
            car.move();
        }
        assertThat(car.state()).isLessThanOrEqualTo(count);
    }

    @Test
    @DisplayName("자동차 경주 게임 실행 결과 테스트")
    void playRacingCarTest() {
        RacingCar racingCar = new RacingCar(3, 5);
        racingCar.play();
    }
}
