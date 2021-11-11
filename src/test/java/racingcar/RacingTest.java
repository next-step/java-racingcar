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

    @BeforeEach
    void setup() {
//        racing = new Racing(3, 5);
        String[] carNames = "pobi,crong,honux".split(",");
        racing = new Racing(carNames, 5);
    }

    @Test
    @DisplayName("List<Car> 생성 테스트")
    void makeCarTest() {
        List<Car> carList = racing.makeCar(5);
        assertThat(carList.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("random 값이 10일 경우, 자동차들이 1번 움직였을 경우 테스트.")
    void goingTryTest() {
        racing.goingTry(10);
        for (Car car : racing.getCarList()) {
            assertThat(car.getState()).isEqualTo(1);
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
        List<Car> carList = racing.makeCar(carNames);

        assertThat(carList.size()).isEqualTo(3);
        for (int i = 0; i < carNames.length; i++) {
            assertThat(carNames[i]).isEqualTo(carList.get(i).getName());
        }
    }
}

