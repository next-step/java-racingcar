package car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.domain.model.Car;
import car.domain.model.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    @Test
    @DisplayName("자동차 리스트 정상 동작")
    void 자동차_리스트_정상_동작 () {
        String carNames = "pobi,crong,honux";
        assertThatCode(()-> new Cars(carNames)).doesNotThrowAnyException();
        Cars cars = new Cars(carNames);
        assertThat(cars.getCars()).extracting(Car::getCarName).containsExactly("pobi", "crong", "honux");
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaa,aaaaaa"})
    @DisplayName("자동차 이름 5자 초과 예외 처리")
    void 자동차_이름_5자_초과 (String str) {
        assertThrows(RuntimeException.class, ()-> new Cars(str));
    }

    @DisplayName("우승자 차량인지 확인하는 테스트")
    @Test
    void isWinnerCar() {
        int maxPosition = 2;
        Car winnerCar = new Car("win");
        Car looserCar = new Car("lol");

        winnerCar.move(5);
        winnerCar.move(9);
        looserCar.move(1);
        looserCar.move(5);

        assertThat(winnerCar.isWinner(winnerCar)).isTrue();
        assertThat(winnerCar.isWinner(looserCar)).isFalse();
    }

}
