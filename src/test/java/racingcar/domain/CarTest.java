package racingcar.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static String TEST_NAME = "test_name";

    @Test
    public void 이동테스트() {
        Car car = new Car(1, "test_name");
        car.move(RandomCreator.createNewPosition());
        assertThat(car.getPosition()).isBetween(1,11);
        assertThat(car.getName()).isEqualTo(TEST_NAME);
    }
}
