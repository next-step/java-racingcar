package step3.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차가 움직이면 -로 측정한다.")
    void 자동차가_전진하면_bar로_측정한다() {
        Car car = new Car(new Moving());
        Assertions.assertThat(car.moving(5)).isEqualTo("-");
    }

    @Test
    void 랜덤한_수를_반환() {
        Car car = new Car(new Moving());
        Assertions.assertThat(car.getRandomMovingNumber()).isGreaterThanOrEqualTo(0)
                                            .isLessThanOrEqualTo(10);
    }

}