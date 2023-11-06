package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car();
    }

    @Test
    @DisplayName("생성된 자동차는 모두 0이라는 출발 포지션을 가진다.")
    void createNewCar() {
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("움직일 수 있는 조건이 된다면 자동차는 1칸 이동하게 된다.")
    void randomMove() {
        car.move(() -> 1);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
