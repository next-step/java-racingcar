package racing.interfaces;

import racing.domain.Car;
import racing.domain.RacingCars;

import java.util.List;

public class ResultView {

    public ResultView() {
        System.out.println("\n실행결과");
    }

    public void printMatchResult(RacingCars racingCars) {
        StringBuilder result = new StringBuilder();
        for (Car car : racingCars.getCars()) {
            result.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        result.append("\n");
        System.out.print(result);
    }

    public void printWinnerResult(List<String> winnerNames) {
        System.out.println(String.join("," + " ", winnerNames) + "가 최종 우승했습니다.");
    }

}
