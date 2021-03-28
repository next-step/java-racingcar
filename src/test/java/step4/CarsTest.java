package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Car;
import step4.domain.Cars;
import step4.domain.Name;
import step4.domain.Position;
import step4.dto.Data;
import step4.util.StringUtil;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차 목록 생성")
    @ValueSource(strings = {"bob,test,weif,a", "a,bb,ccc", "car,move"})
    public void createCar(String names) {
        Data data = new Data(names);

        Cars cars = new Cars();
        cars.createList(data);

        assertThat(cars.getCarList().size()).isEqualTo(StringUtil.splite(data.getNames(), ",").length);

    }

    @Test
    void findWinnerTest() {
        Car bob = new Car("bob", 1);
        Car jack = new Car("jack", 2);
        Car rtos = new Car("rtos", 3);
        Car jun = new Car("jun", 3);

        List<Car> original = Arrays.asList(bob, jack, rtos, jun);
        Cars cars = new Cars(original);
        assertThat(cars.findWinner()).containsExactly(rtos, jun);
    }

    @Test
    void idempotenceFindWinner() {
        Position maxPosition = new Position(5);
        Car bob = new Car(new Name("bob"), new Position(1));
        Car rtos = new Car(new Name("rtos"), maxPosition);
        Car jun = new Car(new Name("jun"), maxPosition);

        List<Car> original = Arrays.asList(bob, rtos, jun);
        Cars cars = new Cars(original);
        assertThat(cars.findWinner().size()).isEqualTo(cars.findWinner().size());
    }
}
