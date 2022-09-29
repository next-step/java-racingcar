package racing.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStringInputHandlerTest {
    @ParameterizedTest
    @CsvSource(value = {"pobi,true", "crong,true", "honux,true", "carson,false", "doyle,true", "miguel,false"})
    void 자동차의_이름은_5글자를_초과할수없다(String name, boolean expected) {
        assertThat(new UserStringInputHandler().validate(name)).isEqualTo(expected);
    }

//    @ParameterizedTest
//    @CsvSource(value = {"a,b,b:false", "a,b,c:true"})
//    void 자동차의_이름이_중복이면_안된다(String name, boolean expected) {
//        assertThat(new UserStringInputHandler().validate(name)).isEqualTo(expected);
//    }

    @ParameterizedTest
    @CsvSource(value = {"a,b,c:3", "a,b:2", "a:1", "abc:1"}, delimiter = ':')
    void 자동차의_이름은_쉼표로_구분한다(String name, int expectedCount) {
        assertThat(new UserStringInputHandler().getUserCount(name)).isEqualTo(expectedCount);
    }
}
