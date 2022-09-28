package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racing.domain.Car;
import study.racing.domain.MovingCondition;
import study.racing.domain.RandomMovingCondition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThat(car.getDistance()).isEqualTo(expected);
    }

    @Test
    void 자동차의_이름을_조회할_수_있다() {
        assertThat(new Car("이름").getName()).isEqualTo("이름");
    }

    @Test
    void 자동차_이름을_입력하지않으면_무작위_이름의_자동차가_생성된다() {
        assertThat(new Car().getName()).isNotBlank();
    }

    @Test
    void 자동차_이름은_5글자를_초과할_수_없다() {
        assertThatThrownBy(() -> {
            new Car("5글자를 충분히 초과하는 이름");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
