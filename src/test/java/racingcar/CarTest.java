package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import static org.assertj.core.api.Assertions.assertThat;
public class CarTest {
    Car car;
    @BeforeEach
    void createInstance(){
        car = new Car("carname1");
    }

    @DisplayName("조건에 맞으면 전진")
    @Test
    void move(){
        // GIVE
        // WHEN
        car.move(()->true);
        // THAT
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("조건에 맞지않으면 전진하지 않음")
    @Test
    void stop(){
        // GIVE
        // WHEN
        car.move(()->false);
        // THAT
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
