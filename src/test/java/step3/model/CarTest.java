package step3.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차가 움직이면 -로 측정한다.")
    void 자동차가_전진하면_bar로_측정한다() {
        Car car = new Car();
        Assertions.assertThat(car.moving()).isEqualTo("-");
    }

}