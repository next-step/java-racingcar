package car.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarResultTest {

    @Test
    void 최대_전진_수에_대한_자동차를_출력한다() {
        CarList carList = new CarList(Arrays.asList(new Car("woo", 1)
                , new Car("na", 2), new Car("boo",2)));
        assertThat(new CarResult(carList));
    }
}