package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("isRunnable이 true이면 자동차의 position 값에 1을 추가한다.")
    @Test
    void moveTestWhenRunnableTrue() {
        //given
        Car car = new Car("Mark");

        //when
        car.move(true);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("isRunnable이 false이면 자동차의 position 값은 변하지 않는다.")
    @Test
    void moveTestWhenRunnableFalse() {
        //given
        Car car = new Car("Mark", 0);

        //when
        car.move(false);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("가장 큰 position 값과 자동차의 position 값이 같다면 winner이다.")
    @Test
    void isWinnerTest() {
        //given
        Car car = new Car("Mark", 5);
        int maxPositionValue = 5;

        //when
        boolean isWinner = car.isWinner(maxPositionValue);

        //then
        assertThat(isWinner).isTrue();
    }
}