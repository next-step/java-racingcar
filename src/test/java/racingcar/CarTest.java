package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    private static final int ATTEMPTS = 5;

    @BeforeEach
    public void setUp() {
        car = new Car(ATTEMPTS);
    }

    @Test
    @DisplayName("moves 배열 검증")
    public void generateMoves() {
        car.generateMoves();
        assertThat(car.getMoves().length).isEqualTo(ATTEMPTS);
    }
}
