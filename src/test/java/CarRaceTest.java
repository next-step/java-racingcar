
import static org.assertj.core.api.Assertions.*;

import Service.CarRace;
import domain.Car;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import repository.CarHistory;

class CarRaceTest extends TestSupport {

    private CarRace carRace;
    private CarHistory carHistory;
    private List<Car> testCarList;

    @BeforeEach
    public void setUp() {

        carRace = new CarRace();
        carHistory = new CarHistory();
        testCarList = new ArrayList<>();

        testCarList.add(testCar1());
        testCarList.add(testCar2());
        testCarList.add(testCar3());

    }

    @Test
    @DisplayName("자동차의 현재상태를 업데이트하는지 확인(처음 상태보다 크거나 같아야 한다)")
    void updateCurrentLocation() {

        carHistory.saveCarHistory(testCarList);

        List<Car> result = carRace.updateCurrentLocation(carHistory, testCarList);

        result.forEach(
            it -> assertThat(it.getCurrentLocation()).isGreaterThanOrEqualTo(INIT_LOCATION));
    }

    @Test
    @DisplayName("주어진 이름으로 자동차 기본상태 리스트를 생성한다")
    void createInitCarList() {

        List<Car> carList = carRace.createInitCarList(testCarNames);

        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).getCarName()).isEqualTo(testCarNames[i]);
        }
    }
}