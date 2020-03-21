package racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {

    @Mock
    private RandomNumber randomNumber;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
        randomNumber = mock(RandomNumber.class);
        assertThat(randomNumber).isNotNull();
    }

    @Test
    void move() {
        car.move();
        car.move();
        car.move();

        assertThat(car.getPositionView()).isEqualTo("---");

        car.move();
        car.move();

        assertThat(car.getPositionView()).isEqualTo("-----");
    }

    @ParameterizedTest
    @CsvSource(value = {"2:", "4:-", "9:-", "3:"}, delimiter = ':')
    @DisplayName("경주를 시작한다는 메시지를 받고 조건(랜덤)을 받아아 전진기능을 수행하는 기능")
    void start(int input, String expected) {
        if (expected == null) {
            expected = "";
        }

        when(randomNumber.generate()).thenReturn(input);
        car.start(randomNumber);

        assertThat(car.getPositionView()).isEqualTo(expected);
    }

}