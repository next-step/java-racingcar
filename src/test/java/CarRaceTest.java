import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.Car;
import domain.Cars;
import service.*;

class CarRaceTest extends TestSupport {

    private Cars cars;
    private CarRace carRace;
    private List<Car> testCarList;

    @BeforeEach
    public void setUp() {

        cars = new Cars(testCarNames);
        carRace = new CarRace();
        testCarList = new ArrayList<>();

        testCarList.add(testCar1());
        testCarList.add(testCar2());
        testCarList.add(testCar3());

    }

    @Test
    @DisplayName("자동차의 현재상태를 업데이트하는지 확인(처음 상태보다 크거나 같아야 한다)")
    void updateCurrentLocation() {

        List<Car> result = carRace.updateCurrentLocation(testCarList);

        result.forEach(
            it -> assertThat(it.getCurrentLocation()).isGreaterThanOrEqualTo(INIT_LOCATION));
    }

    @Test
    @DisplayName("주어진 이름으로 자동차 기본상태 리스트를 생성한다")
    void createInitCarList() {

        List<Car> carList = cars.createInitCarList(testCarNames);

        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).getCarName()).isEqualTo(testCarNames[i]);
        }
    }

    @Test
    @DisplayName("우승자 리스트를 반환한다(같은 거리를 이동했음으로 테스트케이스길이와 같은 값이 반환되어야 한다)")
    void validNameLength() {

        int testCaseSize = testCarList.size();

        List<String> winnerList = cars.findWinner();

        assertThat(winnerList.size()).isEqualTo(testCaseSize);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    @DisplayName("true, false 값에 따라 차의 현재 위치값이 증가하는지 확인한다")
    void carMovingTest(boolean flag, int moving) {

        Car car = new Car("testCar");

        car.move(flag);

        assertThat(car.getCurrentLocation()).isEqualTo(moving);
    }

}