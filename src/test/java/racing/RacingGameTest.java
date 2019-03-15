package racing;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    List<Car> cars;

    @Before
    public void setUp() { cars = new RacingGame(3).getCars(); }

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
