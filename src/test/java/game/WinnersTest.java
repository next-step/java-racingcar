package game;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    public void 리스트를넘기면_우승자반환() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(3,"A"));
        cars.add(new Car(3,"B"));
        cars.add(new Car(1,"C"));
        String anwser = "A, B";
        String winner = Winners.findWinners(cars);

        assertThat(winner).isEqualTo(anwser);
    }
}