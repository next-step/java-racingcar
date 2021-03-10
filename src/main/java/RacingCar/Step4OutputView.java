package RacingCar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Step4OutputView implements OutputView {
    final String FORWARD = "-";
    final String CAR_NAME_POSTFIX = " : ";

    @Override
    public void printTitle() {
        final String TITLE = "실행 결과";
        System.out.println();
        System.out.println(TITLE);
    }

    @Override
    public void printSingleRacingResult(List<Car> cars) {
        cars.forEach(car -> {
            int distance = car.getDistance();
            System.out.print(car.getName() + CAR_NAME_POSTFIX);
            while (distance-- != 0) {
                System.out.print(FORWARD);
            }
            System.out.print('\n');
        });
        System.out.print('\n');
    }

    @Override
    public void printWinners(List<Car> cars) {
        if (cars.isEmpty()) return;

        List<String> winners = getWinnersName(cars);
        System.out.print(winners.get(0));
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(", ");
            System.out.print(winners.get(i));
        }
        System.out.print("가 최종 우승했습니다.\n");
    }

    private List<String> getWinnersName(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .get()
                .getDistance();
    }
}
