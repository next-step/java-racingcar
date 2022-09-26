package study.racing.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    @DisplayName("car의 move메서드는 무빙 조건의 움직이기 위한 조건 상수 보다 큰 입력이 들어오면 움직인다")
    void isMove_ShouldMoveWhenInputIsLargerThanMovingConditionConstant(int input, int expected) {
        //given
        MovingCondition movingCondition = new RandomMovingCondition();
        Car car = new Car(movingCondition);

        //when
        car.move(input);

        //then
        assertThat(car).isEqualTo(new Car(movingCondition, expected));
    }
}
