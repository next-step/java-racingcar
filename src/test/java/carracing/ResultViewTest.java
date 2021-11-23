package carracing;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.Winners;
import carracing.exception.CarNameFormatException;
import carracing.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ResultViewTest {

    @Test
    @DisplayName("정상 출력 확인")
    void printRacing() throws CarNameFormatException {
        ResultView resultView = new ResultView();
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            carList.add(new Car(String.valueOf(i)));
        }

        Cars cars = new Cars(carList);
        resultView.printRacing(cars);
    }

    @Test
    @DisplayName("자동차 이름 출력 확인")
    void printCarName() throws CarNameFormatException {
        ResultView resultView = new ResultView();
        resultView.print(new Car("name"));
    }

    @Test
    @DisplayName("우승 자동차 출력 확인")
    void printWinner() throws CarNameFormatException {
        ResultView resultView = new ResultView();
        List<Car> winnerCars = new ArrayList<>();
        winnerCars.add(new Car("car1"));
        winnerCars.add(new Car("car2"));
        Winners winners = new Winners(winnerCars);
        resultView.printWinner(winners);
    }
}
