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
    void positionFourUnderValue() {
        Car car = new Car(new CarName("test"));
        car.move(() -> true);
        assertEquals(1, car.getPosition());
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

        cars.moveAll();

        assertThat(cars.getCars()).extracting(Car::getCarName).contains("test1", "test2", "test3", "test4", "test5");
    }

    @Test
    @DisplayName("자동차경주 출력 확인")
    void carRacingPrintCheck() {

        String carNames = "test1,test2,test3,test4,test5";

        StringBuilder stringBuilder = new StringBuilder();

        Cars cars = new Cars(carNames);

        for (int i = 0; i < 5; i++) {
            cars.moveAll();
        }

        cars.getCars().forEach(s -> stringBuilder.append(s.getCarName()).append(" : ").append(new String(new char[s.getPosition()]).replace("\0", "-")).append("\n"));

        System.out.println(stringBuilder);

        System.out.println(Winner.printWinner(cars.getCars()) + "가 최종 우승했습니다");
    }

}

