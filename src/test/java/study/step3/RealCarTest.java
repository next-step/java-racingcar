package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.RealCar;

import static org.assertj.core.api.Assertions.assertThat;

class RealCarTest {
    @Test
    @DisplayName("RealCar 객체가 생성되면 ")
    void instantiation() {
        RealCar realCar = new RealCar();
        assertThat(realCar.getId()).isNotNull();
    }
}
