package car.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static car.step3.Main.MAX_LOCATION;

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
    }

    public void winnerResult(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if(car.location() == MAX_LOCATION) {
                winner.add(car.name());
            }
        }
        String winnerResult = String.join(",", winner);
        System.out.println(winnerResult + "가 최종 우승했습니다.");
    }
}
