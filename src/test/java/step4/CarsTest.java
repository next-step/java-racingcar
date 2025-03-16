package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void 자동차들의_이름과_현재_상태를_리턴한다() {
        String[] carNames = {"1", "2", "3"};
        MovingStrategy movingStrategy = () -> true;
        Cars cars = new Cars(carNames, movingStrategy);

        cars.moveAll();

        String expected =
                "1 : -\n" +
                "2 : -\n" +
                "3 : -\n";

        assertThat(cars.getCurrentStatus().toString()).isEqualTo(expected);
    }

}