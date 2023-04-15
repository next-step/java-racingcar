package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Car;
import step3.model.Cars;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarProcessTest {
    private final int TEST_POSITIVE_ONE = 1;
    private final int TEST_NEGATIVE_ONE = -1;

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void 입력된_숫자만큼의_객체_생성(int count) {

        try {
            Method generateCars = RacingProcess.class.getDeclaredMethod("generateCars");
            generateCars.setAccessible(true);
            List<Car> cars = (List<Car>) generateCars.invoke(new RacingProcess(count, TEST_POSITIVE_ONE));


            assertThat(cars.size()).isEqualTo(count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void 음수입력시_예외처리() throws NoSuchMethodException {

        Method generateCars = RacingProcess.class.getDeclaredMethod("countValidation", int.class);
        generateCars.setAccessible(true);

        assertThatThrownBy(() -> generateCars.invoke(new RacingProcess(TEST_NEGATIVE_ONE, TEST_POSITIVE_ONE)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다.");

    }

    @Test
    void 입력된_숫자가_4보다_큰지() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method generateCars = RacingProcess.class.getDeclaredMethod("generateCars");
        generateCars.setAccessible(true);
        List<Car> invokeCars = (List<Car>) generateCars.invoke(new RacingProcess(TEST_POSITIVE_ONE, TEST_POSITIVE_ONE));

        Method isOverLimit = Cars.class.getDeclaredMethod("isOverLimit", int.class);
        isOverLimit.setAccessible(true);
        boolean invoke = (boolean) isOverLimit.invoke(new Cars(invokeCars), 5);

        assertThat(invoke).isTrue();
    }

}
