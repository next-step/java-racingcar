package camp.nextstep.edu.racingcar.domain;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.fail;

public interface RoundHelper {

    default Round createRound(Cars cars) {
        try {
            final Constructor<Round> constructor = Round.class.getDeclaredConstructor(Cars.class);
            constructor.setAccessible(true);
            return constructor.newInstance(cars);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex) {
            return fail();
        }
    }
}
