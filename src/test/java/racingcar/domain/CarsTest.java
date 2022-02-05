package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.movable.RandomForwardStrategy;

class CarsTest {

    @Test
    void 파싱된_자동차_이름으로부터_Car_객체를_생성해_내부에_저장할_수_있다() {
        List<String> input = new ArrayList<>(Arrays.asList("tdd", "lotto", "race"));
        Cars cars = Cars.of(input, new RandomForwardStrategy());

        Assertions.assertThat(cars.getCars().size()).isEqualTo(3);
    }

}
