package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarOperationTest {

    @DisplayName("4 이상인 값으로 CarOperation을 생성할 경우 CarOperation.GO를 생성한다")
    @Test
    void from(){
        assertThat(CarOperation.from(4)).isEqualTo(CarOperation.GO);
        assertThat(CarOperation.from(5)).isEqualTo(CarOperation.GO);
    }

    @DisplayName("4 미만인 값으로 CarOperation을 생성할 경우 CarOperation.STOP을 생성한다")
    @Test
    void from2(){
        assertThat(CarOperation.from(3)).isEqualTo(CarOperation.STOP);
        assertThat(CarOperation.from(2)).isEqualTo(CarOperation.STOP);
    }

}