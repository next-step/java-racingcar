package carRacing;

import car.Car;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    @Test
    void 우승자_찾기(){

        Car 하늘 = new Car("하늘", 1);
        Car 바람 = new Car("바람", 4);
        Car 구름 = new Car("구름", 3);
        Car 햇살 = new Car("햇살", 4);
        List<Car> cars = Arrays.asList(하늘, 바람, 구름, 햇살);

        Winner winner = new Winner();
        List<Car> winners = winner.findWinners(cars);
        assertThat(winners).hasSize(2);
        assertThat(winners).contains(바람, 햇살);
    }
}
