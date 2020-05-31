package autoracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 17})
    public void shouldRecordWhenGoForward(int distance) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car = new Car();
        Method method = Car.class.getDeclaredMethod("goForward", int.class);
        method.setAccessible(true);
        method.invoke(car, distance);
        int historySize = car.getHistory().size();
        assertThat(historySize).isEqualTo(1);
        assertThat(getLastMovement(car)).isEqualTo(Movement.from(distance));
    }

    @Test
    public void shouldRecordWhenStop() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car = new Car();
        Method method = Car.class.getDeclaredMethod("stop");
        method.setAccessible(true);
        method.invoke(car);
        int historySize = car.getHistory().size();
        assertThat(historySize).isEqualTo(1);
        assertThat(getLastMovement(car)).isEqualTo(Movement.STATIONARY);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 8, 10, 100})
    public void hasHistorySameAmountAsRounds(int rounds) {
        Car car = new Car();
        for (int i = 0; i < rounds; i++) {
            car.race();
        }
        assertThat(car.getHistory().size()).isEqualTo(rounds);
    }
}
