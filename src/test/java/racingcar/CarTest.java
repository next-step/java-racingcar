package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.TestMovingStrategy.TestFailMoveStrategy;
import racingcar.TestMovingStrategy.TestSuccessMoveStrategy;
import racingcar.strategy.MovingStrategy;

class CarTest {

    private Car car;
    private MovingStrategy testMovingStrategy;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    public void 자동차_이름_제한_예외() {
        assertThatThrownBy(() -> new Car("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자를 초과");
    }

    @Test
    public void 자동차_이름_제한_통과() {
        Car car = new Car("abcde");
        assertThat(car)
                .extracting("name")
                .isEqualTo("abcde");
    }

    @Test
    public void position_증가() {
        testMovingStrategy = new TestSuccessMoveStrategy();
        car.move(testMovingStrategy);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 포지션증가_실패() {
        testMovingStrategy = new TestFailMoveStrategy();
        car.move(testMovingStrategy);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}