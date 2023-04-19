package step3;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.racing.Car;
import step3.racing.Cars;

import java.util.ArrayList;
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
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        carList.add(new Car());
        cars = new Cars(carList);
    }

    @Test
    void Cars_생성시_사용한_List_요소_변경시_원본_Cars_요소_변경없음() {
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        carList.add(new Car());
        cars = new Cars(carList);

        //when
        carList.get(0).move(5);

        //then
        int actual = cars.deepCopyList().get(0).location();
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void 응답한_deepCopyList_요소_변경시_원본_Cars_요소_변경없음() {
        //given
        List<Car> deepCopyList = cars.deepCopyList();

        //when
        deepCopyList.get(0).move(5);

        //then
        int actual = cars.deepCopyList().get(0).location();
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void 응답한_deepCopyList는_변경_불가한_리스트() {
        //given
        List<Car> deepCopyList = cars.deepCopyList();

        //when
        ThrowableAssert.ThrowingCallable throwable = () -> deepCopyList.add(new Car());

        //then
        assertThatThrownBy(throwable).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 자동차_수_확인() {
        assertThat(cars.count()).isEqualTo(2);
    }
}