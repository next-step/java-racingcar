import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Random random = new Random();

    @Test
    @DisplayName("랜덤값이_4이상이면_move증가")
    void 랜덤값이_4이상이면_move증가() {
        Car car1 = new Car(0);
        Car car2 = new Car(0);

        car1.decideMove(5);
        car1.decideMove(8);

        car2.decideMove(2);

        assertThat(car1.getPosition()).isEqualTo(2);
        assertThat(car2.getPosition()).isEqualTo(0);
    }
}
