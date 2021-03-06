package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("distance의 초기값은 0이어야 한다.")
    void should_ReturnZeroToGetDistance_When_Init() {
        final int expected = 0;

        final int distance = car.getDistance();

        assertThat(distance).isEqualTo(expected);
    }

    @Test
    @DisplayName("distance는 move한 횟수와 같은 값이어야 한다.")
    void should_EqualGetDistanceToMoveCount() {
        final int expected = 4;

        for (int i = 0; i < expected; i++) {
            car.move();
        }

        final int distance = car.getDistance();

        assertThat(distance).isEqualTo(expected);
    }
}
