package race;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    @Test
    void 자동차들은_4_이상의_값을_받으면_전진한다() {
        PowerGenerator powerGenerator = new TestHelper.BigPowerGenerator();
        Cars cars = new Cars(3, powerGenerator);
        assertThat(cars.orderMove())
                .isEqualTo(List.of(true, true, true));
    }

    @Test
    void 자동차들은_3_이하의_값을_받으면_멈춘다() {
        PowerGenerator powerGenerator = new TestHelper.SmallPowerGenerator();
        Cars cars = new Cars(3, powerGenerator);
        assertThat(cars.orderMove())
                .isEqualTo(List.of(false, false, false));
    }
}
