package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.factory.CarFactory;

class CarFactoryTest {

    @Test
    @DisplayName("N대의 자동차를 입력받는 경우")
    void inputTest() {
        String text = "pobi,crong,honux";
        CarFactory carFactory = new CarFactory();
        Car[] cars = carFactory.manufactureCars(text);
        String[] answers = new String[] { "pobi", "crong", "honux" };

        for (int i = 0; i < answers.length; i++) {
            assertThat(
                    cars[i].getName()
            ).isEqualTo(answers[i]);

        }
    }

}
