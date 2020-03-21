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

        assertThat(car.getPosition().getValue()).isEqualTo(3);

        car.move();
        car.move();

        assertThat(car.getPosition().getValue()).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:0", "4:1", "9:1", "3:0"}, delimiter = ':')
    @DisplayName("경주를 시작한다는 메시지를 받고 조건(랜덤)을 받아아 전진기능을 수행하는 기능")
    void start(int input, int expected) {
        when(randomNumber.generate()).thenReturn(input);
        car.start(randomNumber);

        assertThat(car.getPosition().getValue()).isEqualTo(expected);
    }

}