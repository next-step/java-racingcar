package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
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

        List<String> result = cars.getWinnersName();

        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 문자열 생성 테스트 - 우승자 2명")
    void getWinnersListTest() {
        List<Car> carsList = generateCarListMultiWinner();
        Cars cars = new Cars(carsList);

        List<String> result = cars.getWinnersName();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("무조건 이동 가능 조건인 경우 모든 Car 이동 테스트")
    void checkEveryCarMoveTest() {
        List<Car> carsList = generateSameCarList();
        Cars cars = new Cars(carsList);

        cars.playRound(() -> true);

        assertThat(cars.maxPosition()).isEqualTo(MAX_POSITION + 1);
    }

    @Test
    @DisplayName("무조건 이동 불가능 조건인 경우 모든 Car 이동 테스트")
    void checkEveryCarDoNotMoveTest() {
        List<Car> carsList = generateSameCarList();
        Cars cars = new Cars(carsList);

        cars.playRound(() -> false);

        assertThat(cars.maxPosition()).isEqualTo(MAX_POSITION);
    }

    private List<Car> generateSameCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(DEFAULT_CAR_NAME, MAX_POSITION));
        carList.add(new Car(DEFAULT_CAR_NAME, MAX_POSITION));
        carList.add(new Car(DEFAULT_CAR_NAME, MAX_POSITION));

        return carList;
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
