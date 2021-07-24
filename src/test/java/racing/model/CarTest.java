package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("정적_팩토리가_인스턴스를_생성하는지_확인한다")
    void of() {
        Car actual = Car.of("pobi", "-");
        Assertions.assertThat(actual).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("일보전진_테스트")
    void go() {
        Car actual = Car.of("pobi", "-");
        actual.go();
        Assertions.assertThat(actual.position()).isEqualTo("--");
    }

    @Test
    @DisplayName("현재_위치를_확인한다")
    void position() {
        Car actual = Car.of("pobi", "-");
        Assertions.assertThat(actual.position()).isEqualTo("-");
    }
}
