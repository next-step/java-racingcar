package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringSplitterTest {

    @Test
    @DisplayName("문자열을 콤마를 기준으로 분리하여, list로 리턴하는지 에 대한 테스트")
    void splitByComma() {
        //given
        String givenString = "최태훈,조아영,김정환";

        List<String> nameList = StringSplitter.splitByComma(givenString);

        assertThat(nameList.size()).isEqualTo(3);

        assertThat(nameList).containsExactly("최태훈", "조아영", "김정환");
    }
}