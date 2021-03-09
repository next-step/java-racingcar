package racing.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReadonlyCarTest {

    @Test
    @DisplayName("읽기 전용 인터페이스로 필요한 프로퍼티를 가져올 수 있다.")
    void getPropertiesOfCar() {
        Car car = new Car(() -> 1, "test");

        ReadonlyCar readonlyCar = new ReadOnlyCarProxy(car);

        assertAll(
            () -> assertThat(readonlyCar.getName()).isEqualTo(car.getName()),
            () -> assertThat(readonlyCar.getLocation()).isEqualTo(car.getLocation())
        );

    }
}
