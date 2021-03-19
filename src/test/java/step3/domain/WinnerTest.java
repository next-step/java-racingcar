package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinnerTest {

    @DisplayName("주어진 자동차의 우승자들을 반환한다")
    @Test
    public void findWinnerCarNames() {
        Car test1 = new Car("test1", 1);
        Car test2 = new Car("test2", 2);
        Car test3 = new Car("test3", 2);

        List<Car> cars = new ArrayList<>();
        cars.add(test1);
        cars.add(test2);
        cars.add(test3);

        Winner winner = new Winner(new Cars(cars));

        assertThat(winner.findWinnerCarNames()).containsExactly("test2", "test3");
    }
}
