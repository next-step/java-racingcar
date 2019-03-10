package car;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @Test
    public void setCarList() {
        int carSize = 5;
        List<Car> result = RacingGame.setCars(carSize);

        assertThat(result.size()).isEqualTo(carSize);
    }

    @Test
    public void move() {
        int carSize = 5;
        List<Car> carList = makeTestCarList(5);
        List<Car> resultList = RacingGame.playingGame(carList);

        assertThat(resultList.size()).isEqualTo(carSize);
    }

    public List<Car> makeTestCarList(int carCount)  {
        List<Car> testCarList = new ArrayList<>();

        for(int i=0; i<carCount; i++) {
            testCarList.add(new Car());
        }
        return testCarList;
    }

    @Test
    public void carStatusStop() {
        int testRandomValue = 3;
        Car testCar = new Car();
        testCar.move(testRandomValue);

        assertThat(testCar.getMovingCount()).isEqualTo(0);
    }

    @Test
    public void carStatusStart() {
        int testRandomValue = 4;
        Car testCar = new Car();
        testCar.move(testRandomValue);

        assertThat(testCar.getMovingCount()).isEqualTo(1);
    }

}