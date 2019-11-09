package winner.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 14:19
 */
public class CarTest {
    
    @Test
    void car_create_test() {
        assertThat(new Car("kim", 5)).isEqualTo(new Car("kim", 5));
    }

    @Test
    void move() {
        Car car = new Car("pobi", 5);
        car.move(() -> true);
        assertThat(car).isNotEqualTo(new Car("pobi", 5));
    }

    @Test
    void is_max_position_test() {
        int maxPosition = 5;
        Car car = new Car("pbo", 5);
        assertThat(car.isMaxPosition(maxPosition)).isTrue();
    }
}
