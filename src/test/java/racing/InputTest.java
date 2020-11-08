package racing;

import calculator.Operator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racing.controller.RacingController;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;


public class InputTest {

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "-1:true", "-2:true"}, delimiter = ':')
    void testInputNegative(int input, boolean result) throws Exception {
        RacingController rc = new RacingController();
        Method isNotPositiveInt = rc.getClass().getDeclaredMethod("isNotPositiveInt", int.class);
        isNotPositiveInt.setAccessible(true);
        assertThat(isNotPositiveInt.invoke(rc, input)).isEqualTo(result);
    }
}
