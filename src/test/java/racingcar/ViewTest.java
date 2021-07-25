package racingcar;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.ui.ResultView;

import java.util.List;

public class ViewTest {

    @Test
    @DisplayName("자동차 이름 출력")
    void printName(){
        String[] carStrArr = Arrays.array("pobi", "crong", "honux");
        Cars cars = new Cars(carStrArr);
        ResultView.printMovingCars(cars);
    }

    @Test
    @DisplayName("우승자 출력")
    void printWinners(){
        String[] carStrArr = Arrays.array("pobi", "crong", "honux");
        Cars cars = new Cars(carStrArr);
        List<Car> carsList = cars.getCars();
        Car winnerCar = carsList.get(0);
        for(int i=0; i<5; i++){
            winnerCar.move(4);
        }
        Winners winners = new Winners(cars);
        ResultView.printWinners(winners.getWinnerNames());
    }
}
