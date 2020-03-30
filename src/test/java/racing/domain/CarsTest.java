package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private static final String DEFAULT_CAR_NAME = "abc";
    private static final String WINNER_CAR_NAME1 = "bcd";
    private static final String WINNER_CAR_NAME2 = "cde";

    private static final int MAX_POSITION = 5;

    @ParameterizedTest
    @CsvSource(value = {"a,b,c:3", "a,b,123,a2b:4"}, delimiter = ':')
    @DisplayName("주어진 자동차들의 이름을 가진 차들의 배열 생성 테스트")
    void generateCarsListTest(String input, int expected) {
        Cars cars = new Cars(input.split(","));
        assertThat(cars.size()).isEqualTo(expected);
    }

    @Test
    @DisplayName("모든 자동차의 position list를 return 하는지 테스트")
    void getCarsPositionListTest() {
        List<Car> carsList = generateCarList();
        Cars cars = new Cars(carsList);

        List<Integer> result = cars.getCarsPositionList();
        int resultSize = result.size();

        for (int idx = 0; idx < resultSize; idx++) {
            assertThat(result.get(idx)).isEqualTo(carsList.get(idx).getPosition());
        }
    }

    @Test
    @DisplayName("우승자의 위치 확인 테스트")
    void getMaxPositionTest() {
        List<Car> carsList = generateCarListOneWinner();
        Cars cars = new Cars(carsList);

        int result = cars.maxPosition();

        assertThat(result).isEqualTo(MAX_POSITION);
    }

    @Test
    @DisplayName("우승자 문자열 생성 테스트 - 우승자 1명")
    void getWinnerListTest() {
        List<Car> carsList = generateCarListOneWinner();
        Cars cars = new Cars(carsList);

        String result = cars.getWinnersName(",");

        assertThat(result).isEqualTo(WINNER_CAR_NAME1);
    }

    @Test
    @DisplayName("우승자 문자열 생성 테스트 - 우승자 2명")
    void getWinnersListTest() {
        List<Car> carsList = generateCarListMultiWinner();
        Cars cars = new Cars(carsList);

        String result = cars.getWinnersName(",");

        assertThat(result).isEqualTo(String.join(",", Arrays.asList(WINNER_CAR_NAME1, WINNER_CAR_NAME2)));
    }

    private List<Car> generateCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(DEFAULT_CAR_NAME, MAX_POSITION - 3));
        carList.add(new Car(DEFAULT_CAR_NAME, MAX_POSITION - 2));
        carList.add(new Car(DEFAULT_CAR_NAME, MAX_POSITION - 1));

        return carList;
    }

    private List<Car> generateCarListOneWinner() {
        List<Car> carList = generateCarList();
        carList.add(new Car(WINNER_CAR_NAME1, MAX_POSITION));

        return carList;
    }

    private List<Car> generateCarListMultiWinner() {
        List<Car> carList = generateCarListOneWinner();
        carList.add(new Car(WINNER_CAR_NAME2, MAX_POSITION));

        return carList;
    }
}