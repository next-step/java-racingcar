package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("setDistance 테스트")
    void addDistanceTest() {
        //given
        Car car = new Car("");
        car.setDistance(RandomNumCondition.move(new RandomNumCondition()));
        //then
        assertThat(car.getDistance()).contains("");
    }

}