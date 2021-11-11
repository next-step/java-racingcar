package car_racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void createCar() {
        // given
        int id = 1;

        // when
        Car car = new Car(id);

        // then
        assertThat(car.getCurrStatus()).isEqualTo(Status.STOP);
        assertThat(car).isEqualTo(new Car(1, Status.STOP));
    }
}
