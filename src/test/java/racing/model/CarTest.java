package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.move.MoveStrategy;
import racing.model.move.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class CarTest {

    @DisplayName("자동차는 숫자 0에서 9 사이 random 값이 4이상일 경우(RandomMoveStrategy) 전진")
    @Test
    void moveTest() {
        MoveStrategy moveStrategy = () -> true;
        Car car = new Car("car1", moveStrategy);
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 숫자 0에서 9 사이 random 값이 4미만일 경우 정지")
    @Test
    void stopTest() {
        MoveStrategy moveStrategy = () -> false;
        Car car = new Car("car1", moveStrategy);
        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차이름 길이 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"invalidCar"})
    void 자동차이름_5자초과(String input) {

        assertThatIllegalStateException()
                .isThrownBy(() -> new Car(input, () -> true))
                .withMessageMatching("차 이름은 5글자를 초과할 수 없습니다. 다시 입력하세요.");
    }

    @DisplayName("자동차이름 공백 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void 자동차이름_공백_확인(String input) {
        assertThatIllegalStateException()
                .isThrownBy(() -> new Car(input, () -> true))
                .withMessageMatching("차 이름은 공백일 수 없습니다.");
    }
}
