package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @DisplayName("자동차를 생성하면 초기 위치는 0 이다.")
    @Test
    void 초기위치_0() {
        Car car = new Car("noName", () -> true);
        assertThat(car.currentPosition()).isZero();
    }

    @DisplayName("자동차가 전진할수있다.")
    @Test
    void 전진() {
        Car car = new Car("noName", () -> true);
        car.move();
        assertThat(car.currentPosition()).isEqualTo(car.MOVE_DISTANCE);
    }

    @DisplayName("자동차가 멈춘다")
    @Test
    void 멈춤() {
        Car car = new Car("noName", () -> false);
        car.move();
        assertThat(car.currentPosition()).isZero();
    }

    @DisplayName("입력된 레이서 이름 문자열의 공백을 제거")
    @Test
    void 이름_공백_제거() {
        assertThat(Car.replaceAllEmptySpaceInName(" 공 백 문 자 "))
                .isEqualTo("공백문자");
    }
    @DisplayName("입력된 문자열을 쉼표로 구분한다.")
    @Test
    void 이름_쉼표로_구분() {
        assertThat(Car.nameSplitByComma("choi,jae,hyeon"))
                .containsExactly("choi", "jae", "hyeon");
    }
    @DisplayName("구분된 문자열은 5자를 초과하면 IllegalArgumentException 이 발생한다.")
    @Test
    void 이름_글자수_초과() {
        assertThatThrownBy(() -> {
            String[] value = Car.nameSplitByComma("choi,jae,hyeon,choiJaeHyeon");
        }).isInstanceOf(RuntimeException.class).hasMessage("이름은 " + Car.MAXIMUM_NAME_LENGTH + "자를 초과할 수 없습니다.");
    }
}
