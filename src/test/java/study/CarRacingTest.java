package study;

import CarRacing.Car;
import CarRacing.CarName;
import CarRacing.Cars;
import CarRacing.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CarRacingTest {


    @Test
    @DisplayName("자동차 이동 테스트")
    void carMove() {
        Car car = new Car(new CarName("test"));
        car.move(() -> true);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("서로 다른 두 자동차 거리 비교")
    void comparePositionTwoCar() {
        Car car1 = new Car(new CarName("test"));
        Car car2 = new Car(new CarName("test"));
        car1.move(() -> true);
        car2.move(() -> false);
        assertThat(car1.isSamePostion(car2)).isFalse();
    }

    @Test
    @DisplayName("자동차이름 다섯글자 초과시")
    void carNameOverFive() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new CarName("test124"));

        String message = exception.getMessage();

        assertEquals("자동차 이름은 5글자를 초과하지 않습니다.", message);

    }

    @Test
    @DisplayName("자동차이름 빈칸")
    void carNameBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new CarName(""));

        String message = exception.getMessage();

        assertThat("자동차 이름이 비어있으면 안됍니다.").isEqualTo(message);
    }

    @Test
    @DisplayName("cars 이름 확인 테스트")
    void carsCarNameCheck() {
        String carNames = "test1,test2,test3,test4,test5";

        Cars cars = new Cars(carNames);

        assertThat(cars.getCars()).extracting(Car::getCarName).contains("test1", "test2", "test3", "test4", "test5");
    }

    @Test
    @DisplayName("cars Allmove 거리 확인")
    void carsAllmoveCheck() {
        String carNames = "test1,test2,test3,test4,test5";

        Cars cars = new Cars(carNames);

        cars.moveAll(() -> true);
        cars.getCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(1));

    }

    @Test
    @DisplayName("자동차경주 우승자 확인")
    void carRacingPrintCheck() {
        String carNames = "test1,test2,test3,test4,test5";

        Cars cars = new Cars(carNames);

        for (int i = 0; i < 5; i++) {
            cars.getCars().get(0).move(() -> true);
        }

        assertThat(Winner.printWinner(cars.getCars()).get(0)).isEqualTo("test1");
    }

}

