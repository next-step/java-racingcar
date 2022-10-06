import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    @Test
    public void 자동차_리스트_생성(){
        int carCnt = 2;
        List<Car> cars = racingGame.makeCars(carCnt);
        assertThat(cars.size()).isEqualTo(carCnt);
        cars.forEach(car -> {
            assertThat(car.getDistance()).isEqualTo(0);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("자동차_경주 4이상이면 전진처리")
    public void raceMove(){
        Car car = new Car();
        racingGame.race(car,5);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("자동차_경주 4미만이면 정지처리")
    public void raceStop(){
        Car car = new Car();
        racingGame.race(car,1);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
