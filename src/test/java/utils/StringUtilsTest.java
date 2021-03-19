package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("StringUtils 의 splitByComma()가 ,를 기준으로 알맞는 배열의 수를 만드는지 확인하는 테스트")
    @ParameterizedTest(name = "splitByComma 대상이 되는 값: {0}, 예상되는 결과값: {1}")
    @CsvSource(value = {"1,2,3:3", "123:1", ",:0"}, delimiter = ':')
    void splitByCommaTest(String sentence, int expected) {

        // when
        String[] dividedSentences = StringUtils.splitByComma(sentence);
        int actual = dividedSentences.length;

        // then
        assertThat(actual).isEqualTo(expected);

    }

    @DisplayName("StringUtils 의 splitByCommaToList()가 ,를 기준으로 알맞는 리스트를 만드는지 확인하는 테스트")
    @ParameterizedTest(name = "splitByComma 대상이 되는 값: {0}, 예상되는 결과값: {1}")
    @CsvSource(value = {"1,2,3:3", "123:1", ",:0"}, delimiter = ':')
    void splitByCommaToListTest(String sentence, int expected) {

        // when
        List<String> dividedSentences = StringUtils.splitByCommaToList(sentence);
        int actual = dividedSentences.size();

        // then
        assertThat(actual).isEqualTo(expected);

    }


}