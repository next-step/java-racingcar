package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {


    @ParameterizedTest
    @CsvSource(value = {"1,false", "2,false", "3,false", "4,true"})
    void 랜덤_결과가_4이상이면_전진(int randomValue, boolean canMove) {
        Car car = new Car(1);

        assertThat(car.canMove(randomValue)).isEqualTo(canMove);
    }

    @Test
    void Car_생성시_위치_테스트() {
        Car car1 = new Car(1);
        assertThat(car1.getCurrentLocation()).isEqualTo(1);

        Car car2 = new Car(3);
        assertThat(car2.getCurrentLocation()).isEqualTo(3);
    }

    @Test
    void 전진_후_위치_테스트() {
        Car car = new Car(1);
        car.moveForward();
        assertThat(car.getCurrentLocation()).isEqualTo(2);
    }

}
