package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"4,true", "3,false"})
    @DisplayName("랜덤값이 기준을 넘었는지 확인")
    public void isOverTest(int randomValue, boolean result) {
        assertThat(car.isOver(randomValue)).isEqualTo(result);
    }

    @Test
    @DisplayName("move 메소드 확인")
    public void moveTest() {
        car.move();
        assertThat(car.getPosition()).isBetween(0, 1);
    }
}
