package racing;

import java.util.function.Supplier;

public class Driver {
    final Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void drive(Supplier<Integer> randomSupplier) {
        if (randomSupplier.get() >= 4) {
            car.move();
        }
    }

    public void printCurrentDistance() {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
