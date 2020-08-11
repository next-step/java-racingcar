package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("a");
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    public void 값이_4이상일때_1칸_전진한다() {
        car.move(true);
        assertThat(car.getPosition()).isOne();
    }

    @DisplayName("자동차 전진 예외 테스트")
    @Test
    public void 값이_4이하면_움직이지_않는다() {
        car.move(false);
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("차의 이름이 정상적으로 입력되었을 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    public void 정상_동작_테스트(String input) {
        assertThat(new Car(input));
    }

    @DisplayName("차의 이름이 5자를 초과할때 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"poooobi", "crooooong", "hooooonux"})
    public void 이름길이_초과_예외_테스트(String input) {
        assertThatThrownBy(() -> {
            car.validateNameLength(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차의 이름이 공백일 때 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "            "})
    public void 이름길이_공백_예외_테스트(String input) {
        assertThatThrownBy(() -> {
            car.isBlank(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차의 이름이 null 일 때 예외 테스트")
    @Test
    public void 이름_널_예외_테스트() {
        assertThatThrownBy(() -> {
            car.isNull(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
