package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StadiumTest {

    @Test
    @DisplayName("수가 4 이상인지 확인하는 테스트")
    void TestisGreaterThanFour() {
        // when
        Stadium stadium = new Stadium();

        // given
        Boolean actual = stadium.isGreaterThanFour(4);

        // then
        assertTrue(actual);
    }

    @Test
    @DisplayName("수가 4 미만인지 확인하는 테스트")
    void TestisLessThanFour() {
        // when
        Stadium stadium = new Stadium();

        // given
        Boolean actual = stadium.isGreaterThanFour(3);

        // then
        assertFalse(actual);
    }

    @Test
    @DisplayName("4이상이면 자동차 전진 테스트")
    void TestisMove() {
        // when
        Car car = new Car("s",1);
        int number = 4;

        // given
         int expected = 2;
         Stadium.isMove(car, number);
         int actual = car.getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("4미만이면 자동차 전진 실패 테스트")
    void TestisNotMove() {
        // when
        Car car = new Car("s",0);
        int number = 3;

        // given
        int expected = 0;
        Stadium.isMove(car, number);
        int actual = car.getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
