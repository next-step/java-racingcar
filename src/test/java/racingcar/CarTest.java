package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    String[] carNames = {"john", "tom", "myung"};
    Car car = new Car();

    @BeforeAll
    static void beforeAll() {
        Car car = new Car();
    }

    @DisplayName("4이상전진")
    @Test
    void carMoveSuccess() {
        car.go(4);
        assertTrue(car.equalDistance(2));
    }

    @DisplayName("10번전진")
    @Test
    void carMove2() {
        for(int i=0; i<10; i++){
            car.go(10);
        }
        assertThat(car.getDistance()).isGreaterThan(10);
    }

    @DisplayName("4미만전진하지않음")
    @Test
    void carMovefail() {
        car.go(3);
        assertThat(car.equalDistance(1)).isTrue();
    }
}
