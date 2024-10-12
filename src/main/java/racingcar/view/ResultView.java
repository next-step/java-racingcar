package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + generateDashedString(car.getMovingDistance()));
        }

        System.out.println();
    }

    private String generateDashedString(int movingDistance) {
        return "-".repeat(movingDistance);
    }

    public void printRaceWinner(List<Car> winners) {
        String winnerNames = winnersToString(winners);

        System.out.println(winnerNames);
    }

    private String winnersToString(List<Car> winners) {
        List<String> names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        String name = String.join(", ", names);

        return name += "가 최종 우승했습니다.";
    }
}
