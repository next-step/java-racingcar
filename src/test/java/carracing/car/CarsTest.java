package carracing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("position 값이 인자 maxPosition 값과 동일한 자동차들을 조회한다.")
    @Test
    void get_Cars_samePositionAs_argument() {
        Car moon = new Car("moon");
        moon.move(4);
        Car zi = new Car("zi");
        Cars cars = new Cars(List.of(moon, zi));

        assertThat(cars.getCarsSamePositionAs(1)).containsExactly(moon);
    }

    @DisplayName("객체를 깊은 복사한다.")
    @Test
    void deepCopy_object() {
        Cars cars = new Cars(List.of(new Car("moon")));

        assertThat(cars.deepCopy()).isNotSameAs(cars);
    }

    @DisplayName("깊은 복사한 객체는 기존 객체의 변경에 영향을 받지 않는다.")
    @Test
    void change_to_original_object_do_not_affect_deep_copied_object() {
        Cars cars = new Cars(List.of(new Car("moon")));

        Cars deepCopiedCars = cars.deepCopy();
        cars.get().add(new Car("zi"));

        assertThat(cars.get().size()).isNotEqualTo(deepCopiedCars.get().size());
    }

    @DisplayName("필드를 조회한다.")
    @Test
    void get_Cars_field() {
        Car moon = new Car("moon");
        Car zi = new Car("zi");
        Cars cars = new Cars(List.of(moon, zi));

        assertThat(cars.get()).containsExactly(moon, zi);
    }
}