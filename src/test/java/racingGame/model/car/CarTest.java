package racingGame.model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("move 메소드는 입력이 유효한 경우, 1번 움직인다.")
    void move_메소드_전진_테스트() {
        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("move 메소드는 입력이 유효한 경우, 0번 움직인다.")
    void move_메소드_정지_테스트() {
        car.move(() -> false);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
