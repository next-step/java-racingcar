package racingcar.model.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.model.utils.common.Validation.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.dto.InputDTO;

public class ValidationTest {

    private InputDTO inputDTO;

    @DisplayName("객체 초기화")
    @BeforeEach
    void init() {
        inputDTO = new InputDTO(Arrays.asList("a", "aa", "aaa"), 10);
    }

    @DisplayName("유저_입력_글자길이_및_입력_중복_테스트")
    @Test
    void userInputLengthDuplicationTest() {
        String input = inputDTO.getSplitUserInput().stream().map(String::new)
            .collect(Collectors.joining(","));
        assertFalse(validateCarName(input));
    }

    @DisplayName("입력_횟수_범위_테스트")
    @Test
    void userInputRacingTryTest() {
        assertThat(validateNumberRange(inputDTO.getRacingTryCounter()));
    }

    @DisplayName("자동차_입력_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a,aa,aaaaaa"})
    void parsingCarNameTest(String input) {
        assertTrue(validateCarName(input));
    }

    @DisplayName("자동차_입력_테스트")
    @ParameterizedTest
    @ValueSource(ints = 10)
    void parsingRacingTryTest(int input) {
        assertTrue(validateNumberRange(input));
    }

}
