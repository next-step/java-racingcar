package racing.factory;

import static org.assertj.core.api.Assertions.assertThat;

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
        String[] answers = new String[] { "pobi", "crong", "honux" };

        for (int i = 0; i < answers.length; i++) {
            assertThat(
                    cars.get(i).getName()
            ).isEqualTo(answers[i]);
        }
    }

}
