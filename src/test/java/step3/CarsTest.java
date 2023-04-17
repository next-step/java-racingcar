package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void unmodifiableList_변경시_예외() {
        List<Car> unmodifiableList = cars.unmodifiableList();
        assertThatThrownBy(() -> unmodifiableList.add(new Car()))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void unmodifiableList_요소_변경_가능() {
        List<Car> unmodifiableList = cars.unmodifiableList();
        assertThat(unmodifiableList.get(0).location()).isEqualTo(0);
        unmodifiableList.get(0).move(5);
        assertThat(unmodifiableList.get(0).location()).isEqualTo(5);
    }

    @Test
    void unmodifiableList_요소_변경시_원본_리스트_요소도_함께변경() {
        List<Car> unmodifiableList1 = cars.unmodifiableList();
        unmodifiableList1.get(0).move(5);
        List<Car> unmodifiableList2 = cars.unmodifiableList();
        assertThat(unmodifiableList2.get(0).location()).isEqualTo(unmodifiableList1.get(0).location());
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