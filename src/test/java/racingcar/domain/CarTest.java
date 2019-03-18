package racingcar.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static String TEST_NAME = "testName";
    private static int INIT_POSITION = 1;

    @Test
    public void 이동테스트() {
        Car car = new Car(TEST_NAME, INIT_POSITION);
        int moveValue = 4;
        car.move(moveValue);
        assertThat(car.getPosition()).isEqualTo(2);
    }
    
    @Test
    public void 정지테스트() {
        Car car = new Car(TEST_NAME,INIT_POSITION);
        int stopValue = 3;
        car.move(stopValue);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
