package study.step5;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import study.step5.domain.Car;
import study.step5.domain.MovingStrategy;
import study.step5.domain.Position;

/**
 * Car class Test
 */
public class CarTest {

    @DisplayName("자동차 이름 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2", "test"})
    void carNameTest(String carName) {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("자동차 이름 5차 초과(Exception) 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"test12", "test123"})
    void carNameExceptionTest(String carName) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(carName);
        }).withMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("이동 테스트")
    void move() {
        Car car = new Car("test");
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return true;
            }
        });
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("정지 테스트")
    void stop() {
        Car car = new Car("test");
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return false;
            }
        });
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
}
