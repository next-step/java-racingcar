package camp.nextstep.edu.racingcar.domain;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public interface CarsHelper {
    default Cars createCars(Car... car) {
        final List<Car> carList = Arrays.asList(car);
        try {
            final Constructor<Cars> constructor = Cars.class.getDeclaredConstructor(List.class);
            constructor.setAccessible(true);
            return constructor.newInstance(carList);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex) {
            return fail();
        }
    }
}
