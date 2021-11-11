package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingTest {

    private Racing racing;
    private String[] carNames;

    @BeforeEach
    void setup() {
        carNames = "pobi,crong,honux".split(",");
        racing = new Racing(carNames, 5, () -> true);
    }

    @Test
    @DisplayName("List<Car> 생성 테스트")
    void makeCarTest() {
        List<Car> cars = racing.makeCar(5);
        assertThat(cars.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("전진 조건이 만족했을 경우, 자동차들이 전진했는지 테스트.")
    void allMove() {
        Racing racing = new Racing(carNames, 5, () -> true);
        racing.goingTry();
        for (Car car : racing.getCars()) {
            assertThat(car.getState()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("전진 조건이 만족하지 못했을 경우, 자동차들이 멈춰있는지 테스트.")
    void allStop() {
        Racing racing = new Racing(carNames, 5, () -> false);
        racing.goingTry();
        for (Car car : racing.getCars()) {
            assertThat(car.getState()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("자동차 경주 통합 테스트")
    void racingStart() {
        racing.start();
    }

    @Test
    @DisplayName("이름이 주어진 자동차들 생성 테스트")
    void makeCarWithNameTest() {
        String[] carNames = "pobi,crong,honux".split(",");
        List<Car> cars = racing.makeCar(carNames);

        assertThat(cars.size()).isEqualTo(3);
        for (int i = 0; i < carNames.length; i++) {
            assertThat(carNames[i]).isEqualTo(cars.get(i).getName());
        }
    }
}

