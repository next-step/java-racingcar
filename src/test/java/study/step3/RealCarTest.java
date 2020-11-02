package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RealCarTest {
    @Test
    @DisplayName("RealCar 객체가 생성되면 임의의 아이디를 갖는다.")
    void instantiation(){
        RealCar realCar = new RealCar("blue");
        assertThat(realCar.getId()).isNotNull();
    }
}
