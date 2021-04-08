package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final char DELIMITER = ':';
    private Car car;

    @BeforeEach
    private void setCar() {
        car = new Car("test");
        car.move(5);
        car.move(6);
        car.move(7);
    }

    @DisplayName("자동차 경주 테스트 - move")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "4:4", "9:4"}, delimiter = DELIMITER)
    public void testMove(int randomNumber, int position) {
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차 경주 테스트 - isWinner")
    @ParameterizedTest
    @CsvSource(value = {"2:true", "4:false", "9:false"}, delimiter = DELIMITER)
    public void testIsWinner(int max, boolean isWinner) {
        assertThat(car.isWinner(max)).isEqualTo(isWinner);
    }

}
