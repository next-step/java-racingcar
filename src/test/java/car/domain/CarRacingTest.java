package car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    @Test
    void 자동차_전진에_따라_이름_및_전진수를_출력한다() {
        CarList carList = new CarList(Arrays.asList(new Car("woo")
                , new Car("na"), new Car("boo")));
        int playNumber = 3;
        assertThat(new CarRacing(carList, playNumber));

    }
}