package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @DisplayName("자동차를 생성하면 자동차는 초기 위치에 있다.")
    @Test
    void 초기위치_0() {
        Car car = new Car();
        assertThat(car.currentPosition()).isEqualTo(Car.INITIAL_POSITION);
    }

    @DisplayName("자동차가 전진할수있다.")
    @Test
    void 전진() {
        Car car = new Car();
        car.move(() ->true);
        assertThat(car.currentPosition()).isEqualTo(car.MOVE_DISTANCE);
    }

    @DisplayName("자동차가 멈춘다")
    @Test
    void 멈춤() {
        Car car = new Car();
        car.move(() -> false);
        assertThat(car.currentPosition()).isZero();
    }

    @DisplayName("입력된 레이서 이름을 쉼표로 구분한다.")
    @Test
    void 이름_쉼표로_구분() {
        assertThat(Car.nameSplitByDelimiter("choi,jae,hyeon"))
                .containsExactly("choi", "jae", "hyeon");
    }
    @DisplayName("자동차 레이서의 이름이 5자를 초과하면 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"choijae","jaeHyeon","hyeonCar","choiJaeHyeon"})
    void 이름_글자수_초과(String input) {
        assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(RuntimeException.class).hasMessage("이름은 " + Car.MAXIMUM_NAME_LENGTH + "자를 초과할 수 없습니다.");
    }
}
