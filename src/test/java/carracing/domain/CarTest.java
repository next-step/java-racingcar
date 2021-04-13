package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final char DELIMITER = ':';

    @DisplayName("자동차 경주 테스트 - move")
    @Test
    public void testMove() {
        Car car = new Car("rami");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 경주 테스트 - isWinner")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "4:false", "9:false"}, delimiter = DELIMITER)
    public void testIsWinner(int max, boolean isWinner) {
        Car car = new Car("rami");
        car.move(() -> true);
        car.move(() -> true);
        assertThat(car.isWinner(max)).isEqualTo(isWinner);
    }

}
