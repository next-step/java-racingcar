package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("3단계 - 자동차 경주 - 기능 요구사항 테스트")
public class CarRacingFeatureTest {

    @Test
    @DisplayName("자동차 전진 기능")
    void goCar() {
        Car car = new Car();

        car.go();
        car.go();

        assertThat(car.getMovingDistance())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 정지 기능")
    void stopCar() {
        Car car = new Car();

        // 아무것도 하지않으면 정지

        assertThat(car.getMovingDistance())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("차 수 입력 기능")
    void inputNumberOfCar() {

    }

    @Test
    @DisplayName("이동 횟수 입력 기능")
    void inputNumberOfMove() {

    }

    @Test
    @DisplayName("자동차 랜덤 행동 이동 기능")
    void moveRandom() {

    }

    @Test
    @DisplayName("자동차 상태 출력 기능")
    void printCarStatus() {

    }
}
