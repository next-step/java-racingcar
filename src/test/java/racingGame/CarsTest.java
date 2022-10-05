package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.racingRule.FowardRule;
import racingGame.racingRule.NotMoveRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private FowardRule fowardRule = new FowardRule();

    @Test
    @DisplayName("가장 많이 움직인 차의 이름을 리스트에 담아 반환한다.")
    void getWinners(){
        Car winnerCar = new Car("A");
        winnerCar.move(fowardRule);
        Cars cars = new Cars(List.of(winnerCar, new Car("b"), new Car("c")));
        cars.getCars().forEach(car ->  car.move(new NotMoveRule()));
        assertThat(cars.findCoWinner().size()).isEqualTo(1);
        assertThat(cars.findCoWinner().get(0)).isEqualTo("A");
    }
}