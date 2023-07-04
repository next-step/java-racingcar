package racingcar.randommove;

import java.util.function.IntSupplier;
import racingcar.domain.extension.Moveable;

public class RandomMover implements Moveable {

    private final IntSupplier intSupplier;

    public RandomMover(IntSupplier intSupplier) {
        this.intSupplier = intSupplier;
    }

    @Override
    public boolean isMove() {
        return intSupplier.getAsInt() > 3;
    }

}
