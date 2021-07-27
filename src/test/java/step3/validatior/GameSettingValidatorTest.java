package step3.validatior;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.exception.WrongGameSettingException;

class GameSettingValidatorTest {


    @Test
    @DisplayName("주어진 차량이름이 5글자 이하인경우 예외발생이 없다.")
    void test_ok_car_names() {

        List<String> carNames = new ArrayList<>(
            Arrays.asList("car", "car_", "car_3"));
        GameSettingValidator validator = GameSettingValidator.getInstance();

        assertThatCode(() -> {
            validator.validateCarNames(carNames);
        }).doesNotThrowAnyException();

    }


    @ParameterizedTest
    @MethodSource("provideWrongCarNames")
    @DisplayName("주어진 차량이름이 5글자 초과인경우 예외를 던진다.")
    void test_ng_car_names(List<String> wrongCarNames) {

        GameSettingValidator validator = GameSettingValidator.getInstance();

        assertThatThrownBy(() -> {
            validator.validateCarNames(wrongCarNames);
        }).isInstanceOf(WrongGameSettingException.class);

    }

    private static Stream<Arguments> provideWrongCarNames() {
        List<String> wrongCarNames1 = new ArrayList<>(Arrays.asList("car_1111"));
        List<String> wrongCarNames2 = new ArrayList<>(Arrays.asList("car_1", "car_2222"));
        List<String> wrongCarNames3 = new ArrayList<>(Arrays.asList("car_1", "car_2", "car_3333"));
        return Stream.of(
            Arguments.of(wrongCarNames1),
            Arguments.of(wrongCarNames2),
            Arguments.of(wrongCarNames3)
        );
    }
}