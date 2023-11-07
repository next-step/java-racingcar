package racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultViewTest {

    @Test
    void 우승자_선정() {

        Car test1 = new Car("test1");
        Car test2 = new Car("test2");
        test1.move(5);
        test2.move(3);

        List<Car> cars = new ArrayList<>();
        cars.add(test1);
        cars.add(test2);

        List<String> winner = ResultView.winner(cars);
        assertThat(winner.get(0)).isEqualTo("test1");
    }
}