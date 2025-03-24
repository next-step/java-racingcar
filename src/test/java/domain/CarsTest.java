package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.InstanceOfAssertFactories.list;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @DisplayName("입력받은 이름대로 자동차를 생성한다.")
    @Test
    void generateCarsTest() {
        String[] nameOfCars = {"pobi", "crong", "honux"};

        Cars cars = new Cars(nameOfCars);

        assertThat(cars.getCars()).hasSize(nameOfCars.length);
        for (int i = 0; i < nameOfCars.length; i++) {
            assertThat(cars.getCars().get(i).getName()).isEqualTo(nameOfCars[i]);
        }
    }

    @DisplayName("우승자를 반환한다.")
    @Test
    void getWinnersTest() {
        String[] nameOfCars = {"pobi", "crong", "honux"};
        Cars cars = new Cars(nameOfCars);
        NumberGenerator numberGenerator = new StaticNumberGenerator(5);

        cars.getCars().get(0).move(numberGenerator);
        cars.getCars().get(2).move(numberGenerator);

        assertThat(cars.getWinners()).containsExactly("pobi", "honux");
    }
}