package step02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSplitterTest {

    private final NumberSplitter numberSplitter = new NumberSplitter();

    private List<String> expectedNumberList;

    @BeforeEach
    void init() {
        expectedNumberList = new ArrayList<>();
        expectedNumberList.add("1");
        expectedNumberList.add("2");
        expectedNumberList.add("3");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:true", "2:true"}, delimiter = ':')
    @DisplayName("기본 구분자를 기준으로 숫자 객체들을 반환한다")
    void defaultDelimiterTest(int index, boolean hasElement) {
        //given
        String inputText = "1:2:3";

        //when
        List<String> numberList = numberSplitter.extractNumbersWithDelimiter(inputText);

        //then
        assertThat(expectedNumberList.contains(numberList.get(index))).isEqualTo(hasElement);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:true", "2:true"}, delimiter = ':')
    @DisplayName("커스텀 구분자를 기준으로 숫자 객체들을 반환한다")
    void customDelimiterTest(int index, boolean hasElement) {
        //given
        String inputText = "//;\\n1;2;3";

        //when
        List<String> numberList = numberSplitter.extractNumbersWithDelimiter(inputText);

        //then
        assertThat(expectedNumberList.contains(numberList.get(index))).isEqualTo(hasElement);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:true", "2:true"}, delimiter = ':')
    @DisplayName("기본 구분자와 커스텀 구분자를 혼합하여도 숫자 객체들을 반환한다")
    void defaultAndCustomDelimiterTest(int index, boolean hasElement) {
        //given
        String inputText = "//;\\n1;2,3";

        //when
        List<String> numberList = numberSplitter.extractNumbersWithDelimiter(inputText);

        //then
        assertThat(expectedNumberList.contains(numberList.get(index))).isEqualTo(hasElement);
    }

}