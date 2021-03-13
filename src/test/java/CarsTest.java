import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;
import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("test1"));
        carList.add(new Car("test2"));
        carList.add(new Car("test3"));
        cars = new Cars(carList);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void advanceCars(boolean expected, int result) {
        cars.advanceCars(() -> expected);
        assertThat(cars.getCars()
                .get(0)
                .getNumberOfAdvance())
                .isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:true", "1:false"}, delimiter = ':')
    void getWinnerDistance(int input, boolean expected) {
        cars.advanceCars(() -> true);
        cars.getCars().get(0).advance(() -> true);
        assertThat(cars.getWinnerDistance() == input)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"test1:true", "test2:false"}, delimiter = ':')
    void getWinnerNames(String input, boolean expected){
        cars.advanceCars(() -> true);
        cars.getCars()
                .get(0)
                .advance(() -> true);

        assertThat(cars.getWinnerNames()
                .stream()
                .filter(name -> name.equals(input))
                .findFirst()
                .orElse("")
                .equals(input))
                .isEqualTo(expected);
    }
}