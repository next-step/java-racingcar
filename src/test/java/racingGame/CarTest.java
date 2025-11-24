package racingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("전략이 true를 반환하면 자동차는 한 칸 전진한다")
    void move_whenStrategyIsTrue_increasePosition() {
        Car car = new Car("car1");

        car.move(() -> true);
        assertThat(car.position()).isEqualTo(1);
    }

    @Test
    @DisplayName("전략이 false를 반환하면 자동차는 전진하지 않는다")
    void move_whenStrategyIsFalse_keepPosition() {
        Car car = new Car("car1");

        car.move(() -> false);

        assertThat(car.position()).isZero();
    }

    @Test
    @DisplayName("이름이 null 이면 예외가 발생한다")
    void nullName_throwsException() {
        assertThatThrownBy(() -> new Car(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 공백이면 예외가 발생한다")
    void emptyName_throwsException() {
        assertThatThrownBy(() -> new Car(""))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("   "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다")
    void longName_throwsException() {
        assertThatThrownBy(() -> new Car("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 이름으로 생성하면 이름과 초기 위치가 올바르게 설정된다")
    void validName_isCreated() {
        Car car = new Car("pobi");

        assertThat(car.name()).isEqualTo("pobi");
        assertThat(car.position()).isZero();
    }
}
