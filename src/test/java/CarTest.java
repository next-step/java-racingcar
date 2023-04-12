import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("랜덤값을 가져온다(0이상~9이하)")
    void 랜덤값가져오기() {
        RacingCar car = new RacingCar();

        assertThat(car.getRandomNumber()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("전진을 시도한다")
    void 전진시도() {
        RacingCar car = new RacingCar();


        car.tryMove();
    }
}
