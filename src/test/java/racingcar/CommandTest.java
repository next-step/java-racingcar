package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommandTest {


    private Car car;
    private int beforePosition;

    @BeforeEach
    void init() throws NoSuchFieldException, IllegalAccessException {
        car = new Car();
        beforePosition = getCarPositionByReflection(car);
    }

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest(name = "{arguments} 가 입력시, 위치가 변하지 않는다.")
    void commandForwardTest(int command) throws NoSuchFieldException, IllegalAccessException {
        Command.of(command).accept(car);
        int afterPosition = getCarPositionByReflection(car);

        assertThat(beforePosition).isEqualTo(afterPosition);
    }

    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest(name = "{arguments} 가 입력시, 위치가 1 상승한다.")
    void commandNonForwardTest(int command) throws NoSuchFieldException, IllegalAccessException {
        Command.of(command).accept(car);
        int afterPosition = getCarPositionByReflection(car);

        assertThat(beforePosition + 1).isEqualTo(afterPosition);
    }

    @ValueSource(ints = {-1, -5, 100, 50})
    @ParameterizedTest(name = "[{arguments}] 0 ~ 9 가 아니면, IllegalArgumentException 이 발생한다.")
    void invalidInputValueIllegalArgumentExceptionTest(int command) {
        assertThatIllegalArgumentException().isThrownBy(() -> Command.of(command).accept(car));
    }


    private int getCarPositionByReflection(Car car)
        throws NoSuchFieldException, IllegalAccessException {

        Field positionField = Car.class.getDeclaredField("position");
        positionField.setAccessible(true);

        return (int) positionField.get(car);
    }
}