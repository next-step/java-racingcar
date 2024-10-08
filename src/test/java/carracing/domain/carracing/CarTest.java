package carracing.domain.carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("기준 값이 4이상 일때에만 차가 전진해 이동 상태가 1 더해진다.")
    @Test
    void move_car_when_reference_is_between_4_and_9() {
        Car car = new Car("moon");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @DisplayName("기준 값이 4 미만 일때에는 차가 전진하지 않는다.")
    @Test
    void do_not_move_car_when_reference_is_lowerThan_4_or_biggerThan_9() {
        Car car = new Car("moon");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
    @DisplayName("객체를 깊은 복사한다.")
    @Test
    void deepCopy_object() {
        Car car = new Car("moon");

        assertThat(car.deepCopy()).isNotSameAs(car);
    }

    @DisplayName("깊은 복사한 객체는 기존 객체의 변경에 영향을 받지 않는다.")
    @Test
    void change_to_original_object_do_not_affect_deep_copied_object() {
        Car car = new Car("moon");

        Car deepCopiedCar = car.deepCopy();
        car.move(4);

        assertThat(car).isNotEqualTo(deepCopiedCar)
                .isNotSameAs(deepCopiedCar);
    }
}
