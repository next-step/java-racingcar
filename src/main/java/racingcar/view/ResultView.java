package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class ResultView {
    private final List<Cars> roundResult;

    public ResultView(List<Cars> roundResult) {
        this.roundResult = roundResult;
    }

    public static final String DASH = "-";

    public void drawing() {
        for (Cars cars : roundResult) {
            drawDash(cars);
            System.out.println();
        }
        System.out.println();
    }

    public void winner() {
        Cars cars = roundResult.get(roundResult.size() - 1);
        System.out.println(cars.getWinner() + "가 최종 우승했습니다.");
    }

    public void startUI() {
        System.out.println("실행결과");
    }

    private void drawDash(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + ": ");
            System.out.print(DASH.repeat(car.getDistance() + 1));
            System.out.println();
        }
    }
}
