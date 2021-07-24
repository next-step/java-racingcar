package racingcargame.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcargame.domain.common.exception.InvalidNameException;

@DisplayName("이름")
class NameTest {

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "pobi"}
    )
    public void create(String name) {
        // given

        // when
        Name carName = new Name(name);

        // then
        assertThat(carName).isEqualTo(new Name(name));
    }

    @DisplayName("[실패] 생성 - 너무 긴 이름")
    @ParameterizedTest
    @CsvSource(value = {
        "pobipobi"}
    )
    public void create_tooLongName(String name) {
        // given

        // when
        Assertions.assertThrows(InvalidNameException.class, () -> new Name(name));

        // then
    }
}
