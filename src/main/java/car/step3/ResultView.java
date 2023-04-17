package car.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static car.step3.Main.MAX_LOCATION;
import static car.step3.Main.winners;

public class ResultView {
    private final String DASH = "-";
    private final String WINNER = null;

    public ResultView() {
    }

    public void result(List<Car> cars) {
        for (Car car : cars) {
            String printCarLocation = DASH.repeat(car.location());
            System.out.println(car.name() + " : " + printCarLocation);
        }
        System.out.println();
    }

    public void winnerResult(List<Car> cars) {
        for (Car car : cars) {
             addWinner(car);
        }
        String winnerResult = String.join(",", winners);
        System.out.println(winnerResult + "가 최종 우승했습니다.");
    }

    private void addWinner(Car car) {
        if(car.location() == MAX_LOCATION) {
            winners.add(car.name());
        }
    }
}
