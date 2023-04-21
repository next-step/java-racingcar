package car.step3;

import java.util.List;

public class ResultView {
    private final String DASH = "-";

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
        Winner winner = new Winner();
        List<String> winners = winner.findWinner(cars);
        String winnerResult = String.join(",", winners);
        System.out.println(winnerResult + "가 최종 우승했습니다.");
    }
}
