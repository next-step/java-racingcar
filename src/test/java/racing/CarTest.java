package racing;

import org.junit.Test;
import racing.application.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 한칸이동() {
        //given
        Car car = new Car() {
            @Override
            public boolean canMove() {
                return true;
            }
        };

        //when
        int actual = car.move();

        //then
        assertThat(actual).isEqualTo(2);
    }
}