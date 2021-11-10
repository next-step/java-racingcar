package race.outbound;

import race.Car;

import java.util.Collection;

public class OutputView {
    public void render(Collection<Car> cars) {
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
}
