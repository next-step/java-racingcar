package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    private void setCar() {
        car = new Car();
    }

    @DisplayName("0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우 위치를 1 증가시킨다.")
    @Test
    void changeLocation() {
        int originLocation = car.location();

        car.changeLocation(1);
        Assertions.assertThat(car.location()).isEqualTo(originLocation);

        car.changeLocation(4);
        Assertions.assertThat(car.location()).isEqualTo(originLocation + 1);

    }
}
