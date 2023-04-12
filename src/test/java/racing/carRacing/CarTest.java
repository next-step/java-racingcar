package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcde", "abc", "km", "m"})
    @DisplayName("이름 주입 테스트")
    void carNameTest(String input) {
        Car car = new Car(input);

        assertThat(car.getCurrentCar())
                .isEqualTo(input);
    }

    @Test
    @DisplayName("이름이 5글자 이상일 경우 에러 반환 테스트")
    void overCarLengthTest() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자 이상 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈칸일때 에러 반환 테스트")
    void nullOrEmptyTest(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요");;
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 8, 9})
    @DisplayName("이동 테스트")
    void runMoveTest(int input) {
        Car car = new Car(input);

        car.run(() -> true);

        assertThat(car.getCurrentPosition()).isEqualTo(input + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("중지 테스트")
    void runStopTest(int input) {
        Car car = new Car(input);

        car.run(() -> false);

        assertThat(car.getCurrentPosition()).isEqualTo(input);
    }

    @Test
    @DisplayName("우승자인 차 확인 테스트")
    void winnerCarTest() {
        int maxPosition = 3;

        Car car = new Car(3);

        assertThat(car.getMaxPosition(maxPosition)).isTrue();
    }

    @Test
    @DisplayName("우승자가 아닌 차 확인 테스트")
    void loserCarTest() {
        int maxPosition = 3;

        Car car = new Car(2);

        assertThat(car.getMaxPosition(maxPosition)).isFalse();
    }

}
