package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("초기 Car는 1이다.")
    public void initializeCar(){
        assertThat(new Car().getDistance()).isEqualTo(1);
    }


}