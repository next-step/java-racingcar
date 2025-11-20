package racingGame;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("5자를 초과하는 이름으로 자동차를 생성하면 예외가 발생한다")
    void nameTooLong_throwsException() {
        assertThatThrownBy(() -> new Car("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 이름으로 자동차를 생성하면 예외가 발생한다")
    void emptyName_throwsException() {
        assertThatThrownBy(() -> new Car(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 이름으로 생성하면 이름과 초기 위치가 올바르게 설정된다")
    void validName_isCreated() {
        Car car = new Car("pobi");

        assertThat(car.name()).isEqualTo("pobi");
        assertThat(car.position()).isZero();
    }

    @Test
    @DisplayName("전략이 true를 반환하면 자동차는 한 칸 전진한다")
    void move_whenStrategyIsTrue_increasePosition() {
        Car car = new Car("car1");

        car.move(() -> true);

        assertThat(car.position()).isEqualTo(1);
    }

    @Test
    @DisplayName("전략이 false를 반환하면 자동차는 이동하지 않는다")
    void move_whenStrategyIsFalse_positionNotChanged() {
        Car car = new Car("car1");

        car.move(() -> false);

        assertThat(car.position()).isEqualTo(0);
    }

    @Test
    @DisplayName("여러 번 이동하면 누적 이동 거리가 올바르게 증가한다")
    void move_multipleTimes_accumulatesCorrectly() {
        Car car = new Car("car1");

        car.move(() -> true);
        car.move(() -> true);
        car.move(() -> true);

        assertThat(car.position()).isEqualTo(3);
    }
}
