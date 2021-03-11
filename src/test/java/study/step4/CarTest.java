package study.step4;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step4.model.Car;

/**
 * Car class Test
 */
public class CarTest {
    private Car car;

    @BeforeEach
    void init(){
        car = new Car("dhlee");
    }

    @Test
    @DisplayName("위치 반환 테스트")
    void getPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름 반환 테스트")
    void getName() {
        assertThat(car.getName()).isEqualTo("dhlee");
    }

    @ParameterizedTest(name = "움직임 테스트")
    @CsvSource(value = {"1 : 1", "2 : 2", "3 : 3"}, delimiter = ':')
    void move(int distance, int expected) {
        car.move(distance);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
