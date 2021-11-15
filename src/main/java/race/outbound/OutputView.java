package race.outbound;

import race.Car;

import java.util.Collection;
import java.util.stream.Collectors;

public class OutputView {
    public void renderLocation(Collection<Car> cars) {
        cars.forEach(this::renderLocation);
        System.out.println();
    }

    private void renderLocation(Car car) {
        System.out.printf("%-10s: ", car.name().value());
        for (int i = 0; i < car.location(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void renderWinners(Collection<Car> winners) {
        String winnerNames = winners.stream().map(car -> car.name().value()).collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승 했습니다.");
    }
}
