package racing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void moveCarsWithValue4() {
        Car car = new Car(0,"temp");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void moveCarsWithValue3() {
        Car car = new Car(0,"temp");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void compareWinners() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(5,"winner"));
        cars.add(new Car(3,"second"));
        cars.add(new Car(2,"third"));
        assertThat(new RacingResult(cars).getWinners().get(0).getName()).isEqualTo("winner");
        assertThat(new RacingResult(cars).getWinners().get(0).getPosition()).isEqualTo(5);
    }
}
