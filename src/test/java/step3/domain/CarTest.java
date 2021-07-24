package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import step3.runType.HighSpeedRunStrategy;
import step3.runType.NormalRunStrategy;
import step3.runType.RunStrategy;
import step3.runType.TestRunStrategy;

class CarTest {

    private static final int REPEAT_COUNT = 100;

    @RepeatedTest(REPEAT_COUNT)
    @DisplayName("자동차 운행방식이 '테스트운행'일 경우, 자동차는 반드시 1만큼 전진한다.")
    void test_run() {
        String carName = String.format(RacingCars.CAR_NUMBER_FORMAT, 1);

        Car testCar = new Car(carName, new TestRunStrategy());
        testCar.run();

        assertThat(testCar.getRunDistance()).isEqualTo(RunStrategy.NORMAL_PROGRESS_DISTANCE);
    }


    @RepeatedTest(REPEAT_COUNT)
    @DisplayName("자동차 운행방식이 '정상운행'일 경우, 자동차는 0 또는 1 만큼 전진한다.")
    void normal_run() {
        String carName = String.format(RacingCars.CAR_NUMBER_FORMAT, 1);

        Car testCar = new Car(carName, new NormalRunStrategy());
        testCar.run();

        assertThat(testCar.getRunDistance())
            .isBetween(RunStrategy.NO_PROGRESS_DISTANCE, RunStrategy.NORMAL_PROGRESS_DISTANCE);
    }

    @RepeatedTest(REPEAT_COUNT)
    @DisplayName("자동차 운행방식이 '초스피드운행'일 경우, 자동차는 0 또는 2 만큼 전진한다.")
    void hight_speed_run() {
        String carName = String.format(RacingCars.CAR_NUMBER_FORMAT, 1);

        Car testCar = new Car(carName, new HighSpeedRunStrategy());
        testCar.run();

        assertThat(testCar.getRunDistance())
            .isBetween(RunStrategy.NO_PROGRESS_DISTANCE, RunStrategy.HIGH_SPEED_PROGRESS_DISTANCE);
    }

}