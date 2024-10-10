package race.view;

import race.domain.car.Car;
import race.domain.Cars;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printCurrentRoundProgress(Cars cars) {
        Map<String, Integer> currentPositions = cars.getPositions();

        for (Map.Entry<String, Integer> status : currentPositions.entrySet()) {
            String name = status.getKey();
            int position = status.getValue();

            System.out.println(name + "\t: " + "=".repeat(position));
        }

        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        if (winners.isEmpty()) {
            throw new IllegalArgumentException("잘못된 우승자 목록입니다.");
        }

        String result = winners.stream()
                .map(Car::getName)
                .reduce((x, y) -> x + ", " + y)
                .get();


        System.out.println(result + "가 최종 우승했습니다.");
    }
}
