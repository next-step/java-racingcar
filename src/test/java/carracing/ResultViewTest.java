package carracing;

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

        resultView.printRacing(carList);
    }

    @Test
    @DisplayName("자동차 이름 출력 확인")
    void printCarName() throws CarNameFormatException {
        ResultView resultView = new ResultView();
        resultView.print(new Car("name"));
    }

    @Test
    @DisplayName("우승 자동차 출력 확인")
    void printWinner() {
        ResultView resultView = new ResultView();
        List<String> winnerCars = new ArrayList<>();
        winnerCars.add("car1");
        winnerCars.add("car2");
        resultView.printWinner(winnerCars);
    }
}
