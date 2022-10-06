package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.domain.InputValue;
import racingGame.domain.Cars;
import racingGame.testFactory.LoserCarFactory;
import racingGame.testFactory.WinningCarFactory;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("가장 많이 움직인 차의 이름을 리스트에 담아 반환한다.")
    void getWinners(){
        Cars cars = new Cars();
        cars.addNewCar(new InputValue("A","1"),new WinningCarFactory());
        cars.addNewCar(new InputValue("B","1"),new LoserCarFactory());
        cars.getCars().forEach(Car::move);
        assertThat(cars.findCoWinner().get(0)).isEqualTo("A");
        assertThat(cars.findCoWinner()).hasSize(1);
    }
}