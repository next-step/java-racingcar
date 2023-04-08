import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void moveCar() {
        Car moveCar = new Car();
        Car notMoveCar = new Car();

        moveCar.moveCar(4);
        notMoveCar.moveCar(2);


        assertThat(moveCar.getPositionValue()).isEqualTo(1);
        assertThat(notMoveCar.getPositionValue()).isEqualTo(0);
    }


}