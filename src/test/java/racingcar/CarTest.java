package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("hoya");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    @DisplayName("자동차는 MoveStrategy에 따라 움직인다.")
    void move_forward(int input, int expected) {
        car.move(new FourOrMore(new TestRandomHolder(input)));
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
