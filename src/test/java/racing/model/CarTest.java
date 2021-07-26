package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("정적_팩토리가_인스턴스를_생성하는지_확인한다")
    void of() {
        Car actual = Car.of("pobi");
        assertThat(actual).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("일보전진_테스트")
    void go() {
        Car actual = Car.of("pobi");
        actual.go();
        assertThat(actual.position()).isEqualTo(1);
    }

    @Test
    @DisplayName("현재_위치를_확인한다")
    void position() {
        Car car = Car.of("pobi");
        car.go();
        assertThat(car.position()).isEqualTo(1);
    }
}
