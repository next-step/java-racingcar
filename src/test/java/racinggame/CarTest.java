package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.fixture.CarFixture.CAR1;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = CAR1;
    }

    @DisplayName("자동차 전진후 전진상태 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "true | true | false | 2"
    }, delimiter = '|')
    void move(boolean movable1, boolean movable2, boolean movable3, int expected) {
        car.move(movable1);
        car.move(movable2);
        car.move(movable3);

        assertThat(car.currentState()
                .currentPosition())
                .isEqualTo(expected);
    }
}