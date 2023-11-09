package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    void moveSuccessTest(){
        Car car = new Car();
        car.turn(new MovableNumberGenerator());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void moveFailTest(){
        Car car = new Car();
        car.turn(new NotMovableNumberGenerator());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest()
    @CsvSource(value = {"3, 5", "2, 5"})
    void raceTest(int carCount, int tryCount){
        Racing racing = new Racing(carCount);
        for(int i=0; i<tryCount; i++){
            racing.roundStart();
        }
        List<Car> carList = racing.getCarList();
        assertThat(carList.size()).isEqualTo(carCount);
        assertThat(carList).allSatisfy(car -> {
            assertThat(car.getPosition()).isNotNegative().isLessThanOrEqualTo(tryCount);
        });
    }
}
