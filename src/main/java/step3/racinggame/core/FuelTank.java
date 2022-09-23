package step3.racinggame.core;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import step3.racinggame.exception.EmptyTankException;
import step3.racinggame.exception.InvalidFuelException;

public class FuelTank {

    private final Queue<Integer> fuels = new LinkedList<>();

    public Integer takeFuel() {
        return Optional.ofNullable(
                        fuels.poll())
                .orElseThrow(EmptyTankException::new);
    }

    public void addFuel(int fuel) {
        if (fuel < 0 || fuel > 9) {
            throw new InvalidFuelException();
        }

        fuels.add(fuel);
    }
}
