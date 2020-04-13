package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    Car car;

    @BeforeEach
    public void setup() {
        car = new Car(() -> true, "test");
    }

    @DisplayName("항상 성공하는 전략 주입시 position 증가")
    @Test
    public void movePossible() {
        Car car = new Car(() -> true, "test");

        car.moveIfPossible();
        assertThat(car.getPosition()).isEqualTo(1);

        car.moveIfPossible();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @DisplayName("항상 실패하는 전략 주입시 position 유지")
    @Test
    public void moveImpossible() {
        Car car = new Car(() -> false, "test");

        car.moveIfPossible();
        assertThat(car.getPosition()).isEqualTo(0);

        car.moveIfPossible();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("두 번 이동시 max position 비교")
    @ParameterizedTest
    @CsvSource({"1,2", "2,2", "3,3"})
    public void maxPosition(int position, int expected) {
        car.moveIfPossible();
        car.moveIfPossible();

        assertThat(car.getMaxPosition(position)).isEqualTo(expected);
    }

    @DisplayName("잘못된 이름으로 생성시 에러")
    @ParameterizedTest
    @NullAndEmptySource
    public void invalidCarName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(() -> true, name));
    }

}