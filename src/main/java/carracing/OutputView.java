package carracing;

import java.util.List;
import java.util.StringJoiner;

import static java.util.stream.Collectors.toList;

public class OutputView {
    public void printRacingResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName().getName() + " : " + "-".repeat(car.getPosition().getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> cars) {
        List<String> winners = cars.stream()
                .map(Car::getName)
                .map(Name::getName)
                .collect(toList());
        StringJoiner sj = new StringJoiner(", ");
        for (String winner : winners) {
            sj.add(winner);
        }
        System.out.println(sj.toString() + "가 최종 우승했습니다.");
    }
}
