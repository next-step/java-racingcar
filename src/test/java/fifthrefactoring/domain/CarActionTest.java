package fifthrefactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarActionTest {
    private String systemInStringValue = "";

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("자동차 입력값 테스트")
    void carNameInputTest(String testInput) {
        String carName = "pobi";
        System.setIn(new ByteArrayInputStream(systemInStringValue.getBytes()));
        String[] splitCarName =
                CarAction.splitCarName(testInput);
        assertThat(splitCarName[0]).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 초기 세팅 객체테스트")
    void setCarTest() {
        String[] testInput = {"pobi", "crong", "honux"};
        System.setIn(new ByteArrayInputStream(systemInStringValue.getBytes()));
        List<Car> car = CarAction.setCar(testInput);
        assertThat(car.get(0).getCarName()).isEqualTo("pobi");
        assertThat(car.get(0).getCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("항상움직이는자동차테스트")
    void moveCarTest() {
        Car car = new Car("test1");
        car.setStrategy(new MoveAlwaysStrategy());
        car.moveCar(car.move());
        assertThat(car.getCarPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("항상움직이지못하는자동차테스트")
    void notMoveCarTest() {
        Car car = new Car("test1");
        car.setStrategy(new NotMoveStrategy());
        car.moveCar(car.move());
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @Test
    void setRankTest() {
        List<Car> carList = new ArrayList<Car>();

        Car car1 = new Car("test1");
        carList.add(car1);

        Car car2 = new Car("test2");
        car2.moveCar(true);
        carList.add(car2);

        assertThat(CarAction.setRank(carList)).isEqualTo("test2");
    }

}
