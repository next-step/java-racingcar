package laststep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import laststep.domain.Car;
import laststep.service.MoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("이름이 5자 초과시 예외 발생")
    void validateName() {
        assertThatThrownBy(() -> new Car("pobipobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없어요");
    }

    @Test
    @DisplayName("승자 확인")
    void findWinner() {
        MoveStrategy forward = () -> true;
        MoveStrategy stop = () -> false;

        Car testLose = new Car("lose");
        testLose.move(stop);

        Car test = new Car("test");
        test.move(forward);

        Car winner = new Car("win");
        winner.move(forward);

        assertThat(test.isWinner(winner)).isTrue();
        assertThat(testLose.isWinner(winner)).isFalse();
    }

    @Test
    @DisplayName("자동차 생성 확인")
    void car() {
        Car actual = new Car("pobi");
        Car expected = new Car("pobi");

        assertThat(actual).isEqualTo(expected);
    }
}
