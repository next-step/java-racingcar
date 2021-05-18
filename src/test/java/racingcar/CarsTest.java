package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다.")
    @Test
    void gubunCars() {
        String carNames = "pobi,woni,jun";
        Cars cars = new Cars();
        String[] carList = cars.carNames(carNames);
        assertThat(carList).contains("pobi", "woni", "jun");
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void carNameValidation() {
        String carNames = "poig";
        Cars cars = new Cars();
        boolean carNameValidation = cars.carNameLength(carNames);
        assertThat(carNameValidation).isTrue();
    }

    @DisplayName("자동차 한대당 Car객체를 생성한다.")
    @Test
    void createCarCount() {
        String carNames = "pobi,woni,jun";
        Cars cars = new Cars();
        String[] carList = cars.carNames(carNames);
        int carCount = cars.createCars(carList);
        assertThat(carCount).isEqualTo(3);
    }

}