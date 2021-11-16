package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 이동 후 위치가 최대 1만 이동했는지 테스트")
    void carMoveLocationTest() {
        int firstLocation = 2;
        Car car = new Car("이름1", firstLocation);

        NumberGenerator numberGenerator = new NumberGenerator();
        car.move(numberGenerator);
        assertThat(car.getLocation()).isBetween(firstLocation, firstLocation + 1);
    }

}
