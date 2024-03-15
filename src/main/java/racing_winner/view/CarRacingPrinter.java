package racing_winner.view;

import racing_winner.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingPrinter {

    public void printRaceStatus(List<Car> cars) {
        cars.stream().map(Car::getStatus).forEach(System.out::println);
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnersName = winners.stream().map(Car::getName).collect(Collectors.joining());
        System.out.println("Winner is:" + winnersName);
    }
}
