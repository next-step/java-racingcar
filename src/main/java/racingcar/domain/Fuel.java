package racingcar.domain;

import java.util.function.IntSupplier;

@FunctionalInterface
public interface Fuel extends IntSupplier {

    @Override
    int getAsInt();
}
