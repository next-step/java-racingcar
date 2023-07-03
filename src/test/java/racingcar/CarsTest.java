package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동자 목록에 자동차를 추가한다.")
    public void 자동자_목록에_자동차를_추가한다() throws Exception {
        Cars cars = new Cars();

        cars.add(new Car("pobi"));

        assertThat(cars.size()).isEquals(1);
    }
}
