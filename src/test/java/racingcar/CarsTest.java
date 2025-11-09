package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @Test
    void 생성자_입력한_대수만큼_자동차를_생성한다() {
        assertThat(new Cars(3).getValues().size()).isEqualTo(3);
    }

    @Test
    void moveAll_모든_자동차가_이동한다() {
        Cars cars = new Cars(3);
        RandomNumber randomNumber = () -> 4;

        cars.moveAll(randomNumber);

        assertThat(cars.getDistances()).containsExactly(1, 1, 1);
    }
}
