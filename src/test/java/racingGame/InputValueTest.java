package racingGame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingGame.domain.InputValue;
import racingGame.exception.WrongInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValueTest {

    private static Stream<Arguments> provideStringInput(){
        return Stream.of(
                Arguments.of("rol,rrl,rai", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringInput")
    void getCarNames(String carNames, String tryNum) {
        List<String> testSplitList = Arrays.stream(carNames.split(",")).collect(Collectors.toList());

        InputValue inputValue = new InputValue(carNames, tryNum);

        assertThat(inputValue.getCarName()).isEqualTo(testSplitList);
    }

    @ParameterizedTest
    @MethodSource("provideStringInput")
    void getCarsSize(String carName, String tryNum) {
        List<String> testSplitList = Arrays.stream(carName.split(",")).collect(Collectors.toList());

        InputValue inputValue = new InputValue(carName, tryNum);

        assertThat(inputValue.getCarsSize()).isEqualTo(testSplitList.size());
    }

    @ParameterizedTest
    @CsvSource(value = {"layRed,2"})
    void if_carName_over_five_throw_exception(String carName, String tryNum) {
        assertThrows(WrongInputException.class, () ->
                new InputValue(carName,tryNum));
    }
}