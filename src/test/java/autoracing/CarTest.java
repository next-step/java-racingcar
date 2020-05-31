package autoracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.IntStream;

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
    @CsvSource({"0,false", "1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"})
    public void testCanGoForward(int randomValue, boolean expectedGoForward) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car = new Car();
        Method method = Car.class.getDeclaredMethod("canGoForward", int.class);
        method.setAccessible(true);
        boolean enableGoForward = (boolean) method.invoke(car, randomValue);
        assertThat(enableGoForward).isEqualTo(expectedGoForward);
    }

    /**
     * 적절해 보이지 않는다.
     */
    @Test
    public void shouldRecordStationaryOrGoForwardOneWhenRace() {
        Car car = new Car();
        IntStream.range(0, 1000).forEach(car::race);
        assertThat(car.getHistory()).containsOnly(Movement.STATIONARY, Movement.ONE_FORWARD);
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

    public Movement getLastMovement(Car car) {
        int size = car.getHistory().size();
        return car.getHistory().get(size - 1);
    }
}
