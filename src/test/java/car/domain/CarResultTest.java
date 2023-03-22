package car.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarResultTest {

    @Test
    void 자동차_경주에_대한_우승자_점수를_검증한다() {
        CarList carList = new CarList(Arrays.asList(new Car("woo", 1)
                , new Car("na", 4), new Car("boo", 3)));
        CarResult carResult = new CarResult(carList);
        int maxScoreName = carResult.maxScoreCalculate();
        assertThat(maxScoreName).isEqualTo(4);
    }
}
