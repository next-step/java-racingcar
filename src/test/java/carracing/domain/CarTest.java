package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final char DELIMITER = ':';

    @DisplayName("자동차 경주 테스트 - move")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "4:4", "9:4"}, delimiter = DELIMITER)
    public void testMove(int randomNumber, int position) {
        Car car = new Car("rami");
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차 경주 테스트 - isWinner")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "4:false", "9:false"}, delimiter = DELIMITER)
    public void testIsWinner(int max, boolean isWinner) {
        Car car = new Car("rami");
        car.move(7);
        car.move(6);
        assertThat(car.isWinner(max)).isEqualTo(isWinner);
    }

}
