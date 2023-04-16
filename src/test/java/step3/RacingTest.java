package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingTest {

    @Test
    @DisplayName("음의 정수가 입력되면 예외를 발생시킨다.")
    void inputCarCountAndMoveCountException() {
        assertThatThrownBy(() -> Racing.validation(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차는 한번에 1칸을 이동한다")
    void moveCar() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }


    @DisplayName("자동차는 4이상의 랜덤값이 나오면 이동한다")
    @ParameterizedTest
    @CsvSource({"4, true", "3, false"})
    void canMove(int number, boolean expected) {
        assertThat(Racing.canMove(number)).isEqualTo(expected);
    }


}
