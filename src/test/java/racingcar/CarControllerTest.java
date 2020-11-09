package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarControllerTest {

    CarController controller;

    @BeforeEach
    void setup() {
        controller = new CarController();
    }

    @Test
    @DisplayName("CarList 초기화 성공 테스트")
    void initCarListTest() {
        String[] carNames = {"name1", "name2", "name3"};
        CarList carList = controller.initCarList(carNames);

        assertThat(carList.getCarList().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자 점수 계산 테스트")
    void winnerScoreTest() {
        int winnerScore = 5;
        Car car1 = Car.carDtoMapper(new CarDto("a", winnerScore));
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        CarList carList = CarList.from(cars);

        assertThat(controller.getWinnerScore(carList)).isEqualTo(5);
    }
}
