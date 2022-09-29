package racingGame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.exception.WrongInputException;
import racingGame.view.InputVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParametersTest {

    private static Stream<Arguments> provideStringInput(){
        return Stream.of(
                Arguments.of("rol,rrl,rai", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringInput")
    void getCarNames(String carNames, String tryNum) {
        List<String> testSplitList = Arrays.stream(carNames.split(",")).collect(Collectors.toList());

        InputParameters inputParameters = new InputParameters(carNames, tryNum);

        assertThat(inputParameters.getCarName()).isEqualTo(testSplitList);
    }

    @ParameterizedTest
    @MethodSource("provideStringInput")
    void getCarsSize(String carName, String tryNum) {
        List<String> testSplitList = Arrays.stream(carName.split(",")).collect(Collectors.toList());

        InputParameters inputParameters = new InputParameters(carName, tryNum);

        assertThat(inputParameters.getCarsSize()).isEqualTo(testSplitList.size());
    }

    @ParameterizedTest
    @CsvSource(value = {"layRed,2"})
    void if_carName_over_five_throw_exception(String carName, String tryNum) {
        assertThrows(WrongInputException.class, () ->
                new InputParameters(carName,tryNum));
    }
}