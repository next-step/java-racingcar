package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private Car car;

    @BeforeEach
    void createCar() {
        car = new Car();
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 9})
    @DisplayName("4 이상의 값을 인자로 넘기면 자동차는 1칸을 정상적으로 전진한다.")
    public void carRunSuccess(int input) {
        car.run(input);

        assertThat(car.currentPosition()).isEqualTo(new Count(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, -1, -3, 15})
    @DisplayName("10 이상 혹은 0 미만의 값을 인자로 넘기면 예외를 던진다.")
    public void carRunException(int input) {
        assertThatThrownBy(() -> {
            car.run(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 ~ 9");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3})
    @DisplayName("0~3 값을 인자로 넘기면 자동차는 전진하지 않는다.")
    public void carStop(int input) {
        car.run(input);

        assertThat(car.currentPosition()).isEqualTo(new Count(0));
    }
}
