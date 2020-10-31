package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RealCarTest {
    @Test
    @DisplayName("RealCar 객체가 생성되면 ")
    void instantiation() {
        RealCar realCar = new RealCar();
        assertThat(realCar.getId()).isNotNull();
    }
}
