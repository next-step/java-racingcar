package racing.interfaces;

import racing.domain.Car;
import racing.domain.Name;
import racing.domain.RacingCars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public ResultView() {
        System.out.println("\n실행결과");
    }

    public void printMatchResult(RacingCars racingCars) {
        StringBuilder result = new StringBuilder();
        for (Car car : racingCars.getCars()) {
            result.append(car.getName().getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition().getPosition()))
                    .append("\n");
        }
        result.append("\n");
        System.out.print(result);
    }

    public void printWinnerResult(List<Car> winnerCars) {
        List<String> winnerNames = winnerCars.stream()
                .map(Car::getName)
                .map(Name::getName)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

}
