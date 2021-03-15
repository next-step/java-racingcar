package new_racingcar.domain;

import new_racingcar.strategy.MoveOneStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"povi", "1234", "12345", "1"})
    @DisplayName("자동차 이름 5글자 이하만 허용")
    public void carNameLength5DownTest(String inputName) throws Exception {
        //given
        Name name = new Name(inputName);
        //when

        //then
        assertThat(name.getName()).isEqualTo(inputName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"povi123", "1231234", "12312345"})
    @DisplayName("자동차 이름 5글자 초과 에러 발생")
    public void carNameLength5UpErrorTest(String inputName) throws Exception {
        //given

        //when,then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name(inputName);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름 공백 시 에러 발생")
    public void carNameLength0ErrorTest(String inputName) throws Exception {
        //given

        //when,then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name(inputName);
        });
    }
}
