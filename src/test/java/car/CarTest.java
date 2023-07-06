package car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import car.domain.Car;
import car.util.Movable;
import car.util.RandomCarMovable;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("단일 자동차 전진 테스트 정상 동작")
    void 단일_자동차_전진_정상_동작() {
        int amount = 1;
        Car car = new Car("hello");

        car.move(amount);

        Assertions.assertThat(car.getPosition()).isEqualTo(amount);
    }

    @Test
    @DisplayName("Movable 객체가 정해준 만큼 차는 움직인다.")
    void 자동자_움직_가능() {
        // given
        Movable movable = new RandomCarMovable();
        Car car = new Car("hello");
        int decideMoving = movable.decideMoving();

        car.move(decideMoving);

        assertThat(car).extracting("position").isEqualTo(decideMoving);
    }
}
