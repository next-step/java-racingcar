package racing.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

class CarFactoryTest {

    @Test
    @DisplayName("N대의 자동차를 입력받는 경우")
    void inputTest() {
        String text = "pobi,crong,honux";
        CarFactory carFactory = CarFactory.getInstance();

        List<Car> cars = carFactory.manufactureCars(text);

        assertThat(cars).extracting("name").containsExactlyInAnyOrder("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("5자를 초과하는 자동차 이름이 입력된 경우")
    void carNameOverFiveTest() {
        String text = "12345,123456";
        CarFactory carFactory = CarFactory.getInstance();

        assertThatThrownBy(() -> carFactory.manufactureCars(text))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되는 자동차 이름이 입력된 경우")
    void duplicatedCarNameTest() {
        String carNames = "pobi,pobi";
        CarFactory carFactory = CarFactory.getInstance();

        assertThatThrownBy(() -> carFactory.manufactureCars(carNames))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열이나 공백이 입력됐을 경우")
    void blankCarNameTest() {
        String carNames = ",  ";
        CarFactory carFactory = CarFactory.getInstance();

        assertThatThrownBy(() -> carFactory.manufactureCars(carNames))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}
