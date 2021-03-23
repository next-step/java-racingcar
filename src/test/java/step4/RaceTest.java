package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Car;
import step4.domain.Cars;
import step4.domain.Data;
import step4.domain.Winner;
import step4.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @ParameterizedTest
    @DisplayName("승리자 다수")
    @ValueSource(strings = {"bob,test,weif,a","a,bb,ccc","car,move"})
    public void winners(String names){
        Winner winner = new Winner();
        Cars cars = new Cars();
        cars.createdList(new Data(names));

        for(Car car : cars.getCarList()){
            car.move(5);
        }
        winner.findWinner(cars);
        new ResultView().renderWinner(winner.getWinners());

        assertThat(cars.getCarList().size()).isEqualTo(winner.getWinners().size());
    }

    @ParameterizedTest
    @DisplayName("승리자 없음")
    @ValueSource(strings = {"bob,test,weif,a","a,bb,ccc","car,move"})
    public void noWinner(String names){
        Winner winner = new Winner();
        Cars cars = new Cars();
        cars.createdList(new Data(names));

        for(Car car : cars.getCarList()){
            car.move(0);
        }
        winner.findWinner(cars);

        new ResultView().renderWinner(winner.getWinners());
        assertThat(winner.getWinners().size()).isZero();
    }
}
