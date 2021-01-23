package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.NameValidator;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class NameValidatorTest {

    @Test
    @DisplayName("잘못된 이름 테스트")
    public void carNameCheckerTest() {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("asd", "aaaaaa"));
        ArrayList<String> test2 = new ArrayList<>(Arrays.asList("asd", "aaa"));
        assertThat(NameValidator.checkCarName(test)).isFalse();
        assertThat(NameValidator.checkCarName(test2)).isTrue();
    }
}
