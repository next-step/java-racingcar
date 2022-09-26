package racinggame.domain.gasstation;

import java.util.Queue;
import racinggame.domain.exception.EmptyTankException;

public class TankGasStation implements GasStation {

    private final Queue<Integer> tank;

    public TankGasStation(Queue<Integer> tank) {
        this.tank = tank;
    }

    public int sellFuel() {
        if (tank.peek() == null) {
            throw new EmptyTankException();
        }
        return tank.poll();
    }
}
