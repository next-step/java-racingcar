package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.addCar(new Car());
        cars.addCar(new Car());
    }

    @Test
    void 자동차_수_확인() {
        assertThat(cars.count()).isEqualTo(2);
    }

    @Test
    void deepCopyList_요소_변경시_원본_요소_변경없음() {
        List<Car> copy1 = cars.deepCopyList();
        copy1.get(0).move(5);
        List<Car> copy2 = cars.deepCopyList();

        int actual = copy1.get(0).location();
        int expected = copy2.get(0).location();
        assertThat(actual).isNotEqualTo(expected);
    }
}