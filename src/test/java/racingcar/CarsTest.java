package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class CarsTest {
    @Test
    @DisplayName("자동차 객체 생성")
    public void success() {
        // given
        String names = "test1,test2";

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars).isNotNull();
    }
}
