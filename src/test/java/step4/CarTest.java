package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Car;
import step4.helper.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("각 자동차에 이름을 부여한다.")
    @Test
    void test() {
        String nameStr = "hyper,prodo,sam";
        List<Car> cars = CarFactory.createCars(nameStr);
        assertThat(cars).hasSize(3);

        String[] nameSplit = nameStr.split(",");
        for (int i = 0; i < nameSplit.length; i++) {
            assertThat(cars.get(i).getName()).isEqualTo(nameSplit[i]);
        }
    }

    @DisplayName("자동차의 이름은 5자를 초과할 수 없다")
    @Test
    void test2() {
        new Car("prodo");

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    new Car("hypenova1");
                });


    }

}
