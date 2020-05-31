package autoracing;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @Test
    public void newCar() {
        Car car = new Car();
        Condition<Car> init = new Condition<>(c -> c.getLocation(0) == Location.STARTING_LINE, "init");
        assertThat(car).is(init);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.getLocation(1))
                .withMessage("The car has never played that round '1'.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 17})
    public void shouldRecordWhenDriving(int distance) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car = new Car();
        Method method = Car.class.getDeclaredMethod("drive", int.class);
        method.setAccessible(true);
        method.invoke(car, distance);
        int lastRound = car.getLastRound();
        assertThat(lastRound).isEqualTo(1);
        assertThat(car.getLocation(lastRound)).isEqualToComparingFieldByField(new Location(distance, 1));
    }

    @Test
    public void shouldRecordWhenStay() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car = new Car();
        Method method = Car.class.getDeclaredMethod("stay");
        method.setAccessible(true);
        method.invoke(car);
        int lastRound = car.getLastRound();
        assertThat(lastRound).isEqualTo(1);
        assertThat(car.getLocation(lastRound)).isEqualToComparingFieldByField(new Location(0, 1));
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

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 8, 10, 987})
    public void hasHistorySameAmountAsRounds(int rounds) {
        Car car = new Car();
        for (int i = 0; i < rounds; i++) {
            car.race();
        }
        assertThat(car.getLastRound()).isEqualTo(rounds);
    }
}
