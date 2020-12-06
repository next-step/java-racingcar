package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGeneratorTest {
    @Test
    @DisplayName("자동차 1대 생성")
    void geneate_0_car_test() {
        CarGenerator cargenerator = new CarGenerator();
        Cars cars = cargenerator.generateCar(1);
        assertThat(cars.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 다섯대 생성")
    void geneate_5_cars_test() {
        CarGenerator cargenerator = new CarGenerator();
        Cars cars = cargenerator.generateCar(5);
        assertThat(cars.size()).isEqualTo(5);
    }
}
