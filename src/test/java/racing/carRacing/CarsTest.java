package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("cars 초기화 테스트")
    void carsInitTest() {
        Cars cars = Cars.initCars("test1,test2", () -> true);

        assertThat(cars.getCarsSize()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ",,"})
    @DisplayName("input으로 콤마(,)만 있을 때 에러 반환")
    void onlyCommaErrorTest(String input) {
        assertThatThrownBy(() -> Cars.initCars(input, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("cars 단독 우승자 구하기")
    void getWinnerTest() {
        Cars cars = Cars.initCars("test1,test2,test3", () -> true);

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
        Cars cars = Cars.initCars("test1,test2,test3", () -> true);

        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);

        String winner = cars.getWinner();

        assertThat(winner).isEqualTo("test1, test2");
    }

}
