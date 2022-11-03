package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("생성된 자동차의 개수")
    void carCount(){
        List<String> list = Arrays.asList("car1","car2");
        Cars cars = Cars.makeCars(list);
        assertThat(cars.getCars()).hasSize(2);
    }

    @Test
    @DisplayName("생성된 자동차가 없을 시 에러발생")
    void carsNullChk(){
        assertThatThrownBy(() -> Cars.makeCars(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("자동차를 생성해주세요");
    }

    @Test
    @DisplayName("우승자 찾기")
    void carWinenr(){
        List<Car> racingCars = Arrays.asList(new Car("car1", 5)
                                        , new Car("car2", 6)
                                        , new Car("car3",7));
        Cars cars = new Cars(racingCars);
        assertThat(cars.carWinner()).contains("car3");
    }
}
