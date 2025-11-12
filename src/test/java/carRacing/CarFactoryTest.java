package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {
    @Test
    @DisplayName("자동차 이름을 2가지 넣으면, 사이즈 2의 리스트가 반환된다")
    void carFactory_size() {
        assertThat(CarFactory.initRacingCars("kim,lee")).hasSize(2);
    }
}