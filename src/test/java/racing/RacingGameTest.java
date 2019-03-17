package racing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    List<Car> cars = new ArrayList<Car>();

    @Before
    public void setUp() {
        cars.add(new Car(0));
    }

    @Test
    public void moveCarsTestWithValue4() {
        for(Car car:cars){
            car.move(4);
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    public void moveCarsTestWithValue3() {
        for(Car car:cars){
            car.move(3);
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

}
