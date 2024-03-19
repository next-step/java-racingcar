import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Random random = new Random();

    @Test
    @DisplayName("랜덤값이_4이상이면_move증가")
    void 랜덤값이_4이상이면_move증가() {
        Car car = new Car(0);

        car.moveOnCondition(5);
        car.moveOnCondition(8);

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("랜덤값이_4미만이면_move증가X")
    void 랜덤값이_4미만이면_move증가X() {
        Car car = new Car(0);

        car.moveOnCondition(2);
        car.moveOnCondition(1);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
