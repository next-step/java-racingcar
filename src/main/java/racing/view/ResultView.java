package racing.view;

import racing.entity.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printResult(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> result.append(buildCarResult(car)).append("\n"));
        System.out.println(result.toString());
    }

    private String buildCarResult(Car car) {
        return car.getName() + ": " + carPosition(car.getPosition());
    }

    private String carPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void findWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("우승자는 " + winnerNames + " 입니다.");
    }
}

