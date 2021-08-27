package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;
    private RandomNumCondition randomNumCondition;

    @BeforeEach
    void setUp() {
        randomNumCondition = new RandomNumCondition();
        car = new Car();
    }

    @Test
    @DisplayName("setDistance 테스트")
    void addDistanceTest() {
        //given
        car.addDistance(() -> true);
        //then
        assertThat(car.getDistance().get(0)).isTrue();
    }
}