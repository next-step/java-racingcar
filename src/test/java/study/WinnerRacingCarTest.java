package study;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WinnerRacingCarTest {
    private WinnerRacingCar winnerRacingCar = new WinnerRacingCar();

    @Test
    void 우승자찾기() {
        Car test1 = new Car("test1", 1);
        Car test2 = new Car("test2", 2);
        Car test3 = new Car("test3", 3);
        List<Car> cars = Arrays.asList(test1, test2, test3);
        List<Car> winnerCar = winnerRacingCar.findWinnerCar(cars);
        assertThat(winnerCar).hasSize(1);
        assertThat(winnerCar).contains(test3);
    }

    @Test
    void 경주하는차량만들기() {
        List<Car> cars = winnerRacingCar.makeRacingCar("pobi,crong,honux");
        assertThat(cars).hasSize(3);
    }

    @Test
    void 우승자거리찾기(){
        Car test1 = new Car("test1", 1);
        Car test2 = new Car("test2", 2);
        Car test3 = new Car("test3", 3);
        List<Car> cars = Arrays.asList(test1, test2, test3);
        assertThat(winnerRacingCar.maxPosition(cars)).isEqualTo(3);
    }

    @Test
    void 우승자이름만들기() {
        Car test1 = new Car("test1");
        Car test2 = new Car("test2");
        Car test3 = new Car("test3");
        List<Car> cars = Arrays.asList(test1, test2, test3);
        assertThat(winnerRacingCar.makeWinnerName(cars)).isEqualTo("test1,test2,test3");
    }



}
