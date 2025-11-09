package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @Test
    void 생성자_입력한_대수만큼_자동차를_생성한다() {
        Cars cars = new Cars(3);

        assertThat(cars.getValues().size()).isEqualTo(3);
    }
}
