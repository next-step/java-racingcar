package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.util.List;

public class RacingTest {

    private Racing racing;

    @BeforeEach
    void setup() {
        racing = new Racing(3, 5);
    }

    @Test
    @DisplayName("List<Car> 생성 테스트")
    void makeCarTest() {
        List<Car> carList = racing.makeCar(5);
        Assertions.assertThat(carList.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("random 값이 10일 경우, 자동차들이 1번 움직였을 경우 테스트.")
    void goingTryTest(){
        racing.goingTry();
        for (Car car : racing.getCarList()) {
            Assertions.assertThat(car.getState()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("자동차 경주 통합 테스트")
    void racingStart(){
        racing.start();
    }

}

