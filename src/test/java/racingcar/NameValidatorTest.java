package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.NameValidator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

public class NameValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "'asd', 'aaaaaa'",
            "'asd', 'asdkfjasdlkfj'"
    })
    @DisplayName("잘못된 이름 테스트")
    public void carNameCheckerTest(String input1, String input2) {
        ArrayList<String> test = new ArrayList<>(Arrays.asList(input1, input2));
        assertThat(NameValidator.checkCarName(test)).isFalse();
    }
}
