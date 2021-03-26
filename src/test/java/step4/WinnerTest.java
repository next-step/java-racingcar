package step4;


import org.junit.jupiter.api.Test;
import step4.domain.Car;
import step4.domain.Winner2;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void findWinnerTest() {

        Car bob = new Car("bob", 1);
        Car jack = new Car("jack", 2);
        Car rtos = new Car("rtos", 3);
        Car jun = new Car("jun", 3);

        List<Car> original = Arrays.asList(bob, jack, rtos, jun);
        assertThat(new Winner2().findWinner(original)).containsExactly(rtos, jun);
    }

}
