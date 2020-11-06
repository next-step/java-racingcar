package racingcar.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.asset.ExceptionConst;
import racingcar.exeption.BadMaxRaceException;
import racingcar.exeption.BadNameCsvException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = InputView.getInstance();
    }

    @ParameterizedTest
    @DisplayName("5자가 넘는 이름이 있으면 BadNameCsvException 이 발생한다.")
    @CsvSource(value = {"a,:true", "ab,12345:true", "ab,123456:false"}, delimiter = ':')
    void validateNameCsv(String nameCsv, boolean isValid) {
        if (isValid) {
            Assertions.assertDoesNotThrow(() -> {
                inputView.validateNameCsv(nameCsv);
            });
            return;
        }
        assertThatExceptionOfType(BadNameCsvException.class)
                .isThrownBy(() -> {
                    inputView.validateNameCsv(nameCsv);
                }).withMessage(ExceptionConst.BAD_NAME_CSV_MSG);
    }

    @ParameterizedTest
    @DisplayName("숫자를 입력하지 않으면 BadMaxRaceException 이 발생한다.")
    @CsvSource(value = {"1:true", "0:false", "-1:false", ":false", "Hello World:false"}, delimiter = ':')
    void validateMaxRace(String maxRace, boolean isValid) {
        if (isValid) {
            Assertions.assertDoesNotThrow(() -> {
                inputView.validateMaxRace(maxRace);
            });
            return;
        }
        assertThatExceptionOfType(BadMaxRaceException.class)
                .isThrownBy(() -> {
                    inputView.validateMaxRace(maxRace);
                }).withMessage(ExceptionConst.BAD_MAX_RACE_MSG);
    }
}
