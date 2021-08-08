package step3.util;

import step3.domain.Car;

import java.util.List;

public class ResultView {

    private final String GAME_RESULT = "실행결과";
    private final String DASH = "-";

    public void printGameResult(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getDistance());
        }
    }

    public void printGameResultHeader() {
        System.out.println(GAME_RESULT);
    }

    public void printNewLine() {
        System.out.println();
    }
}
