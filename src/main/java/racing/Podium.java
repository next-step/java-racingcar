package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Podium {

    public static void printRacing(int rounds, List<Car> cars) {
        for (int i = 0; i < rounds; i++) {
            printRound(i, cars);
        }
    }

    public static void printWinners(List<Car> cars) {
        List<String> winners = getWinner(cars);
        System.out.println("최종우승자: " + String.join(", ", winners));
    }

    private static void printRound(int roundNumber, List<Car> cars) {
        for (Car car : cars) {
            printCarDistance(roundNumber, car);
        }
        System.out.println();
    }

    private static void printCarDistance(int roundNumber, Car car) {
        String name = car.getName();
        int dist = car.getRoundDistance(roundNumber);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dist; i++) {
            sb.append('-');
        }

        System.out.println(name + " : " + sb);
    }

    private static List<String> getWinner(List<Car> cars) {
        cars.sort((a, b) -> b.getDistance() - a.getDistance());
        int bestScore = cars.get(0).getDistance();
        return cars.stream().filter(car -> car.getDistance() == bestScore)
            .map(car -> car.getName())
            .collect(Collectors.toList());
    }
}
