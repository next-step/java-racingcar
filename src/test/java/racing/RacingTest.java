package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    void 자동차_생성() {
        List<Car> cars = GameMain.generateCar(3);
        int number_0 = cars.get(0).carNumber();
        int number_1 = cars.get(1).carNumber();
        int number_2 = cars.get(2).carNumber();
        int distance = cars.get(0).carDistance();

        assertThat(number_0).isEqualTo(0);
        assertThat(number_1).isEqualTo(1);
        assertThat(number_2).isEqualTo(2);
        assertThat(distance).isEqualTo(0);
    }
}
