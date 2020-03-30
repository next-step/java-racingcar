package racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringUtilTest {

    @DisplayName("문자열과 구분자를 전달하면 해당 구분자로 문자열을 분리한다")
    @Test
    public void splitString() throws Exception {
        //given
        String input = "a,b,c,d";
        String delimiter = ",";

        //when
        List<String> result = StringUtil.splitString(input, delimiter);

        //then
        assertThat(result.size()).isEqualTo(4);

    }

}
