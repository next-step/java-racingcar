package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 가장_멀리간_자동차의_거리를_리턴한다() {
        Cars cars = new Cars(Arrays.asList("a", "b", "c"));

        cars.getCars().forEach(car -> car.move(3)); //다른 객체라서 실행해도 maxMovingDistance 0으로 나옴

        int maxMovingDistance = cars.getMaxMovingDistance();
        assertThat(maxMovingDistance).isEqualTo(3);
    }
}