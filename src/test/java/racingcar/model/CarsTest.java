package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차의_이름이_주어졌을때_자동차_리스트가_생성된다() {
        String[] carNames = new String[]{"wonie", "povie", "jobie"};

        List<Car> cars = Cars.createCars(carNames);

        assertThat(cars.get(0).getCarName()).isEqualTo("wonie");
        assertThat(cars.get(1).getCarName()).isEqualTo("povie");
        assertThat(cars.get(2).getCarName()).isEqualTo("jobie");
    }

    @Test
    void 자동차가_전진한다() {
        Cars racingCars = new Cars();
        List<Car> cars = Arrays.asList(new Car("wonie"), new Car("povie"), new Car("jobie"));

        List<Car> racingResults = racingCars.moveForwardByCount(cars);
        assertThat(racingResults.get(0).getPosition()).isNotNull();
        assertThat(racingResults.get(1).getPosition()).isNotNull();
        assertThat(racingResults.get(2).getPosition()).isNotNull();
    }

}