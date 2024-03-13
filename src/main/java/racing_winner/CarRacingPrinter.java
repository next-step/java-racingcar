package racing_winner;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingPrinter {

    public void printRaceStatus(List<Car> cars) {
        cars.stream().map(Car::getStatus).forEach(System.out::println);
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
//        if (winners.isEmpty())
//            throw new IllegalArgumentException("우승자는 필수입니다.");
        String winnersName = winners.stream().map(Car::getName).collect(Collectors.joining());
        System.out.println("Winner is:" + winnersName);
    }
}
