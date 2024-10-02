package racingGame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("move 메소드는 입력이 유효한 경우, 1번 움직인다.")
    void move_메소드_전진_테스트(final int number) {
        car.move(number);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("move 메소드는 입력이 유효한 경우, 0번 움직인다.")
    void move_메소드_정지_테스트(final int number) {
        car.move(number);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
