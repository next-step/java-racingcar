package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarGeneratorTest {

    @Test
    void 문자열과_이동전략을_주입받아_차를_생성한다() {
        List<Car> cars = CarGenerator.createCars(Arrays.asList("a", "b", "c", "d"), new RandomMoveRule());
        assertThat(cars).hasSize(4);
        assertThat(cars).allSatisfy(car -> assertThat(car.getDistance()).isEqualTo(0));
    }
}
