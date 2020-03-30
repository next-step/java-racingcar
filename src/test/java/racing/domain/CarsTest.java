package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest {
    private static final String DEFAULT_CAR_NAME = "abc";

    @ParameterizedTest
    @EmptySource
    @DisplayName("주어진 문자열이 null 이거나 빈 문자열일 경우 empty list return 테스트")
    void getEmptyListWithCarSizeZero(String input) {
        Cars cars = new Cars(input);
        assertTrue(cars.getList().isEmpty());
    }

    @ParameterizedTest
    @CsvSource(value = {"a,b,c:3", "a,b,123,a2b:4"}, delimiter = ':')
    @DisplayName("주어진 자동차들의 이름을 가진 차들의 배열 생성 테스트")
    void generateCarsListTest(String input, int expected) {
        Cars cars = new Cars(input);
        assertThat(cars.size()).isEqualTo(expected);
    }

    @Test
    @DisplayName("모든 자동차의 position list를 return 하는지 테스트")
    void getCarsPositionListTest() {
        List<Car> carsList = generateCarsList();
        Cars cars = new Cars(carsList);

        List<Integer> result = cars.getCarsPositionList();
        int resultSize = result.size();

        for (int idx = 0; idx < resultSize; idx++) {
            assertThat(result.get(idx)).isEqualTo(carsList.get(idx).getPosition());
        }
    }

    private List<Car> generateCarsList() {
        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car(DEFAULT_CAR_NAME, 2));
        carList.add(new Car(DEFAULT_CAR_NAME, 3));
        carList.add(new Car(DEFAULT_CAR_NAME, 4));
        carList.add(new Car(DEFAULT_CAR_NAME, 5));

        return carList;
    }
}