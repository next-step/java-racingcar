package racing;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    public void moveCar() {
        Car car = new Car();
        List<Integer> moveList = car.moveCar(4);
        assertThat(moveList.size()).isEqualTo(4);
    }
}