package racingcar.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @Before
    public void setup() {
        car = new Car("테스트차1");
    }

    @Test
    public void 전진_가능한_경우_테스트() {
        int randomNumber = 4;
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 전진_불가능한_경우_테스트() {
        int randomNumber = 3;
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 세칸_이동_테스트() {
        int randomNumber = 4;
        car.move(randomNumber);
        car.move(randomNumber);
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    public void 우승_테스트() {
        int winnerPosition = 10;
        Car winnerCar = new Car("우승차1", winnerPosition);
        assertThat(winnerCar.isWinner(winnerPosition)).isTrue();
    }

    @Test
    public void 우승이_아닌경우_테스트() {
        int winnerPosition = 10;
        Car loserCar = new Car("달팽이차", 5);
        assertThat(loserCar.isWinner(winnerPosition)).isFalse();
    }
}
