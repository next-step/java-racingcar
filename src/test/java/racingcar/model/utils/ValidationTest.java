package racingcar.model.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static racingcar.model.utils.common.Parsing.parsingCarName;
import static racingcar.model.utils.common.Parsing.racingTryCheck;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        assertFalse(parsingCarName(input));
    }

    @DisplayName("입력_횟수_범위_테스트")
    @Test
    void userInputRacingTryTest() {
        assertThat(racingTryCheck(inputDTO.getRacingTryCounter()));
    }

}
