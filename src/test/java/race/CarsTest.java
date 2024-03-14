package race;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void 자동차_생성() {
        Cars cars = new Cars();
        int number = 3;
        List<Car> carList = cars.createCar(number);
        assertThat(carList).hasSize(number);
        IntStream.range(0,number).forEach(
                index -> assertThat(carList.get(index).location).isZero()
        );
    }

    @Test
    void 전진_결정() {
        Cars cars = new Cars();
        boolean value = cars.canForward(4);
        assertThat(value).isTrue();
    }

    @Test
    void 정지_결정() {
        Cars cars = new Cars();
        boolean value = cars.canForward(3);
        assertThat(value).isFalse();
    }
}
