package carracing.domain.carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
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

        assertThat(cars).isNotEqualTo(deepCopiedCars)
                .isNotSameAs(deepCopiedCars);
    }

    @DisplayName("필드를 반환한다.")
    @Test
    void return_Cars_field() {
        Car moon = new Car("moon");
        Car zi = new Car("zi");
        Cars cars = new Cars(List.of(moon, zi));

        assertThat(cars.get()).containsExactly(moon, zi);
    }

    @DisplayName("자동차 경주 게임의 우승 차의 이름을 반환한다.")
    @Test
    void return_winnersNames() {
        Car moon = new Car("moon", 2);
        Car zi = new Car("zi", 1);
        Cars cars = new Cars(List.of(moon, zi));

        assertThat(cars.winnersNames())
                .containsExactly(moon.getNameString());
    }

    @DisplayName("주어진 이름 별 차들을 생성한다.")
    @Test
    void create_cars() {
        assertThat(Cars.create(new String[]{"moon", "zi"}).get()).hasSize(2);
    }
}