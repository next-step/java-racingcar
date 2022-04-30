package carrace.util;

import carrace.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SplitterTest {
    Splitter splitter = new Splitter();

    @Test
    @DisplayName("입력받은 carNames -> cars로 변환 확인")
    void splitCarNames() {
        String carNames = "jess,test,kim";
        List<Car> cars = splitter.splitCarNames(carNames);

        assertThat(cars.get(0)).isEqualTo(new Car("jess"));
        assertThat(cars.get(1)).isEqualTo(new Car("test"));
        assertThat(cars.get(2)).isEqualTo(new Car("kim"));
    }
}