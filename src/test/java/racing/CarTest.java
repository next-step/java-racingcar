package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("정적_팩토리가_인스턴스를_생성하는지_확인한다")
    void of() {
        Car actual = Car.of("siro", "-");
        Assertions.assertThat(actual).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("비어있는_인스턴스를_생성하는_정적_팩토리를_확인한다")
    void emptyCar() {
        Car actual = Car.emptyCar();
        Assertions.assertThat(actual).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("일보전진_테스트")
    void go() {
        Car actual = Car.emptyCar();
        actual.go();
        Assertions.assertThat(actual.position()).isEqualTo("-");
    }

    @Test
    @DisplayName("현재_위치를_확인한다")
    void position() {
        Car actual = Car.emptyCar();
        Assertions.assertThat(actual.position()).isEqualTo("");
    }
}
