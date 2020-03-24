package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest {

    @Test
    @DisplayName("주어진 수가 0일 경우 empty list return 테스트")
    void getEmptyListWithCarSizeZero() {
        Cars cars = new Cars(0);
        assertTrue(cars.getList().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 6})
    @DisplayName("주어진 수 만큼의 자동차를 가지는 배열 생성 테스트")
    void generateCarsListTest(int input) {
        Cars cars = new Cars(input);
        assertThat(cars.size()).isEqualTo(input);
    }

    @Test
    @DisplayName("모든 자동차의 position list를 return 하는지 테스트")
    void getCarsPositionListTest() {
        List<Car> carsList = generateCarsList();
        Cars cars = new Cars(carsList);
        List<Integer> positionList = cars.getCarsPositionList();

        for (int idx = 0; idx < positionList.size(); idx++) {
            assertThat(positionList.get(idx)).isEqualTo(carsList.get(idx).getPosition());
        }
    }

    private List<Car> generateCarsList() {
        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car().setPosition(2));
        carList.add(new Car().setPosition(3));
        carList.add(new Car().setPosition(4));
        carList.add(new Car().setPosition(5));

        return carList;
    }
}
