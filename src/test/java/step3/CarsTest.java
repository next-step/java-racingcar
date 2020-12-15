package step3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void 우승자_테스트() {
        Car winner = new Car("win");
        Car loser1 = new Car("lo1");
        Car loser2 = new Car("lo2");
        winner.move();
        Cars cars = new Cars(new ArrayList<Car>() {{
            add(winner);
            add(loser1);
            add(loser2);
        }});
        List<Car> winners = cars.getWinners();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo(winner);
    }

    @Test
    public void 여러_우승자_테스트() {
        Car winner1 = new Car("win1");
        Car winner2 = new Car("win1");
        Car loser2 = new Car("lo2");
        winner1.move();
        winner2.move();
        Cars cars = new Cars(new ArrayList<Car>(){{
            add(winner1);
            add(winner2);
            add(loser2);
        }});
        List<Car> winners = cars.getWinners();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo(winner1);
        assertThat(winners.get(1)).isEqualTo(winner2);
    }

    @Test
    public void 모두_우승_테스트() {
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        Cars cars = new Cars(new ArrayList<Car>(){{
            add(car1);
            add(car2);
            add(car3);
        }});
        List<Car> winners = cars.getWinners();
        assertThat(winners).isEqualTo(new ArrayList<Car>(){{
            add(car1);
            add(car2);
            add(car3);
        }});
    }

}
