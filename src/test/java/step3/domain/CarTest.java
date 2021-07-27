package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.runType.HighSpeedRunStrategy;
import step3.runType.NormalRunStrategy;
import step3.runType.TestRunStrategy;

class CarTest {

    @Test
    @DisplayName("자동차 운행방식이 '테스트운행'일 경우, 자동차는 반드시 1만큼 전진한다.")
    void test_run() {
        String carName = "car1";

        Car testCar = new Car(carName);
        testCar.run(new TestRunStrategy());

        assertThat(testCar.getRunDistance()).isEqualTo(TestRunStrategy.NORMAL_PROGRESS_DISTANCE);
    }


    @Test
    @DisplayName("자동차 운행방식이 '정상운행'일 경우, 자동차는 0 또는 1 만큼 전진한다.")
    void normal_run() {
        String carName = "car1";

        Car testCar = new Car(carName);
        testCar.run(new NormalRunStrategy());

        assertThat(testCar.getRunDistance())
            .isBetween(
                NormalRunStrategy.NO_PROGRESS_DISTANCE,
                NormalRunStrategy.NORMAL_PROGRESS_DISTANCE);
    }

    @Test
    @DisplayName("자동차 운행방식이 '초스피드운행'일 경우, 자동차는 0 또는 2 만큼 전진한다.")
    void high_speed_run() {
        String carName = "car1";

        Car testCar = new Car(carName);
        testCar.run(new HighSpeedRunStrategy());

        assertThat(testCar.getRunDistance())
            .isBetween(
                HighSpeedRunStrategy.NO_PROGRESS_DISTANCE,
                HighSpeedRunStrategy.HIGH_SPEED_PROGRESS_DISTANCE);
    }

}