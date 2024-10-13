package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4,2", "3,1"})
    public void 자동차_전진테스트(int capacity, int position) {
        String name = "test";
        Car car = Car.defaultCar(name);
        car.move(capacity);
        assertThat(car).isEqualTo(new Car(position, name));
    }

    @Test
    public void 자동차_이름_길이검증_테스트() {
        assertThatThrownBy(() -> new Car(0, "")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(0, null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(0, "nexts")).isInstanceOf(IllegalArgumentException.class);
        assertThatCode(() -> new Car(0, "next")).doesNotThrowAnyException();
    }

    @Test
    public void 위치_검증_테스트() {
        Car car = new Car(1, "test");
        assertThat(car.isPositionEqual(1)).isTrue();
        assertThat(car.isPositionEqual(2)).isFalse();
    }

}
