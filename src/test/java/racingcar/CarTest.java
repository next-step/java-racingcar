package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;
    private int beforePosition;

    @BeforeEach
    void init() throws NoSuchFieldException, IllegalAccessException {
        car = new Car();
        beforePosition = getCarPositionByReflection(car);
    }

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest(name = "{arguments} 가 입력시, 자동차는 이동하지 않는다.")
    void nonForwardTest(int command) throws Exception {

        car.action(command);
        int afterCommand = getCarPositionByReflection(car);

        assertThat(afterCommand).isEqualTo(beforePosition);
    }

    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest(name = "{arguments} 가 입력시, 자동차는 한칸 전진한다.")
    void forwardTest(int command) throws Exception {
        car.action(command);
        int afterCommand = getCarPositionByReflection(car);

        assertThat(afterCommand).isEqualTo(beforePosition + 1);
    }


    @ValueSource(ints = {-1, -5, 100, 50})
    @ParameterizedTest(name = "[{arguments}] 0 ~ 9 가 아니면, IllegalArgumentException 이 발생한다.")
    void invalidInputValueIllegalArgumentExceptionTest(int command) {
        assertThatIllegalArgumentException().isThrownBy(() -> car.action(command));
    }


    private int getCarPositionByReflection(Car car)
        throws NoSuchFieldException, IllegalAccessException {

        Field positionField = Car.class.getDeclaredField("position");
        positionField.setAccessible(true);

        return (int) positionField.get(car);
    }

}