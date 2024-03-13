package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.Model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("차량의 초기 위치는 0")
    void carInitialValueTest() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("차량의 전진 기능 테스트")
    void moveCarTest() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(10);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜던값이 1~3은 정지, 4~9는 전진 기능 테스트")
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void carMoveConditionTest(int value, int expected) {
        Car car = new Car();
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(expected);
    }


}
