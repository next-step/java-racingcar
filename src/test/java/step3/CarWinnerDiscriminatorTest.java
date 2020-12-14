package step3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarWinnerDiscriminatorTest {

    @Test
    public void 우승자_테스트() {
        Car winner = new Car("win");
        Car loser1 = new Car("lo1");
        Car loser2 = new Car("lo2");
        winner.move();
        List<Car> cars = Arrays.asList(winner, loser1, loser2);
        List<Car> winners = CarWinnerDiscriminator.discriminate(cars);
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
        List<Car> cars = Arrays.asList(winner1, winner2, loser2);
        List<Car> winners = CarWinnerDiscriminator.discriminate(cars);
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo(winner1);
        assertThat(winners.get(1)).isEqualTo(winner2);
    }

    @Test
    public void 모두_우승_테스트() {
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        List<Car> winners = CarWinnerDiscriminator.discriminate(cars);
        assertThat(winners).isEqualTo(cars);
    }

}
