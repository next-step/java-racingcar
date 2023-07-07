package racingcar.util;

import racingcar.car.Position;

public class MathUtil {

    public static Position max(Position a, Position b) {
        return (a.getValue() >= b.getValue()) ? a : b;
    }
}
