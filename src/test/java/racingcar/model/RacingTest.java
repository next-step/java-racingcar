package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 테스트")
class RacingTest {
    private final List<Car> testCar = List.of(new Car("test", () -> 0));

    @Test
    @DisplayName("우승자를 확인할 수 있다")
    public void winner() {
        Car car1 = new Car("car1", () -> 1);
        Car car2 = new Car("car2", () -> 0);

        Racing racing = new Racing(1, List.of(car1, car2));
        racing.step();

        assertThat(racing.winners()).containsExactly(car1);
    }

    @Test
    @DisplayName("공동 우승자를 확인할 수 있다")
    public void winners() {
        Car car1 = new Car("car1", () -> 1);
        Car car2 = new Car("car2", () -> 1);

        Racing racing = new Racing(1, List.of(car1, car2));
        racing.step();

        assertThat(racing.winners()).containsExactly(car1, car2);
    }

    @Test
    @DisplayName("게임이 끝나기 전엔 우승자를 알 수 없다")
    public void winnersAfterEnd() {
        Car car1 = new Car("car1", () -> 1);
        Car car2 = new Car("car2", () -> 1);

        Racing racing = new Racing(10, List.of(car1, car2));
        racing.step();

        assertThatThrownBy(racing::winners)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("race is not over");
    }

    @Test
    @DisplayName("차가 null 이면 예외 발생")
    public void nullCars() {
        assertThatThrownBy(() -> new Racing(1, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차가 없으면 예외 발생")
    public void emptyCars() {
        assertThatThrownBy(() -> new Racing(1, List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("설정한 라운드 이상으로 진행하면 예외가 난다.")
    public void cannotStepOverRound() {
        Racing racing = new Racing(10, testCar);

        for (int count = 0; count < 10; count++) {
            racing.step();
        }

        assertThatThrownBy(racing::step)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("race is over");
    }

    @Test
    @DisplayName("레이스가 끝났는 지 확인할 수 있다")
    public void isOver() {
        Racing racing = new Racing(10, testCar);

        for (int count = 0; count < 10; count++) {
            racing.step();
        }

        boolean over = racing.isOver();
        assertThat(over).isTrue();
    }

    @Test
    @DisplayName("레이스가 안 끝났는 지 확인할 수 있다")
    public void isNotOver() {
        Racing racing = new Racing(10, testCar);
        for (int count = 0; count < 5; count++) {
            racing.step();
        }

        boolean over = racing.isOver();
        assertThat(over).isFalse();
    }

    @Test
    @DisplayName("현재까지 진행한 라운드를 알 수 있다")
    public void currentRound() {
        Racing racing = new Racing(10, testCar);
        for (int count = 0; count < 5; count++) {
            racing.step();
        }

        int current = racing.currentRound();
        assertThat(current).isEqualTo(5);
    }

    @Test
    @DisplayName("라운드 횟수는 음수일 수 없다")
    public void nonNegativeRound() {
        assertThatThrownBy(() -> new Racing(-1, testCar))
                .isInstanceOf(IllegalArgumentException.class);
    }
}