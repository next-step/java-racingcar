package step3;

import java.util.Comparator;
import java.util.List;

public class RaceWinner {
    
    public List<String> getWinners(List<Car> cars) {
        return winnerNames(cars, maxPosition(cars));
    }

    private List<String> winnerNames(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.position() == maxPosition)
                .map(Car::name)
                .collect(java.util.stream.Collectors.toList());
    }

    private int maxPosition(List<Car> cars) {
        return cars.stream().max(Comparator.comparing(Car::position)).get().position();
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자는 ");
        winners.forEach(winner -> System.out.print(winner + ","));
        System.out.println(" 입니다.");
    }
}
