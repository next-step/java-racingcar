package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("cars 초기화 테스트")
    void carsInitTest() {
        CarNames carNames = CarNames.createCarNames("test1,test2");
        Cars cars = Cars.initCars(carNames);

        assertThat(cars.getCarsSize()).isEqualTo(2);
    }

    @Test
    @DisplayName("cars 단독 우승자 구하기")
    void getWinnerTest() {
        CarNames carNames = CarNames.createCarNames("test1,test2,test3");
        Cars cars = Cars.initCars(carNames);

        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);

        String winner = cars.getWinner();

        assertThat(winner).isEqualTo("test1");
    }

    @Test
    @DisplayName("cars 복수 우승자 구하기")
    void getMultipleWinnerTest() {
        CarNames carNames = CarNames.createCarNames("test1,test2,test3");
        Cars cars = Cars.initCars(carNames);

        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);

        String winner = cars.getWinner();

        assertThat(winner).isEqualTo("test1, test2");
    }

}
