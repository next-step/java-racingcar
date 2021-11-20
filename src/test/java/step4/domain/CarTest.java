package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @DisplayName("distance만큼 움직인 위치를 position 리스트에 저장한다.")
    @Test
    void move() {
        Car car = new Car("pobi");
        car.move(1);
        assertThat( car.getCurrentPosition()).isEqualTo(1);

        car.move(1);
        assertThat( car.getCurrentPosition()).isEqualTo(2);


        car.move(0);
        assertThat( car.getCurrentPosition()).isEqualTo(2);

    }

}