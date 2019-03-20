package racingcar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    private ResultView resultView;

    @Test
    public void sortByValueTest() {
        resultView = new ResultView();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            carList.add(new Car("a" + i, i));
        }
        resultView.sortByValue(carList);
        int maxPosition = carList.get(0).getPosition();
        assertThat(maxPosition).isEqualTo(2);
    }

    @Test
    public void getWinnersTest() {
        Car car1 = new Car("test1", 0);
        Car car2 = new Car("test2", 1);
        List<Car> carList = new ArrayList<>();
        carList.add(car2);
        carList.add(car1);
        resultView = new ResultView();
        List<Car> winners = resultView.getWinners(carList);
        assertThat(winners.get(0).getCarName()).isEqualTo("test2");

    }
}