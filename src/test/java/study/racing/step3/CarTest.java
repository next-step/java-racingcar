package study.racing.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    @DisplayName("car의 isMovable메서드는 4보다 크거나 같은 입력이 들어오면 true를 반환한다.")
    void isMovable_ShouldReturnTrueWhenInputIsLargerThan4(int input, boolean expected) {
        //given
        Car car = new Car();

        //when
        boolean result = car.isMovable(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("car의 move메서드는 차량을 한 칸 움직인다.")
    void isMove_plusDistance() {
        //given
        Car car = new Car();
        int distance = car.getDistance();

        //when
        car.move();

        //then
        assertThat(car.getDistance()).isEqualTo(distance + 1);
    }
}
