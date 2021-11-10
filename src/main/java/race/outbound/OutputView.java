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
        System.out.printf("%-10s: ", car.name());
        for (int i = 0; i < car.location(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void renderWinners(Collection<Car> cars) {
        String winnerNames = cars.stream().map(car -> car.name().toString()).collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승 했습니다.");
    }
}
