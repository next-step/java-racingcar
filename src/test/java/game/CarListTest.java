package game;

import org.junit.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CarListTest {

    @Test
    public void 길이테스트() {
        List<Car> cars = CarList.makeCars("A,B,C");
        assertThat(cars).isNotEmpty().hasSize(3);
    }
}