package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @DisplayName("Numbers 객체 생성 테스트")
    @Test
    public void newNumberInstanceTest() {
        //given
        String source = "2 + 3 * 4 / 2";

        //when
        Numbers numbers = new Numbers(source.split(Constant.BLANK));

        //then
        assertThat(numbers).isNotNull();
    }

    @DisplayName("Numbers 자료구조 테스트 : 앞에 있는 숫자가 먼저 나온다 FIFO")
    @Test
    public void numberFirstInFirstOutTest() {
        //given
        String source = "2 + 3 * 4";

        //when
        String[] splitValue = source.split(Constant.BLANK);
        Numbers numbers = new Numbers(splitValue);

        //then
        int i = 0;
        while (numbers.hasNext()) {
            double number = numbers.get();
            assertThat(number)
                    .isEqualTo(Double.parseDouble(splitValue[2 * i++])); //splitValue[0], splitValue[2], splitValue[4]
        }
    }

    @DisplayName("Numbers 자료구조 테스트 : 숫자 갑이 존재하면 hasNext true")
    @Test
    public void numbersCollectionHasNextTrueTest() {
        //given
        String source = "2 + 3 * 4";

        //when
        String[] splitValue = source.split(Constant.BLANK);
        Numbers numbers = new Numbers(splitValue);

        //then
        assertThat(numbers.hasNext()).isTrue();
    }

    @DisplayName("Numbers 자료구조 테스트 : 숫자 값이 존재하지 않으면 hasNext false")
    @Test
    public void numbersCollectionHasNextFalseTest() {
        //given
        String source = "2 + 3 * 4";

        //when
        String[] splitValue = source.split(Constant.BLANK);
        Numbers numbers = new Numbers(splitValue);
        numbers.get();
        numbers.get();
        numbers.get();

        //then
        assertThat(numbers.hasNext()).isFalse();
    }

    @DisplayName("입력받는 String 이 숫자형 문자열인지 확인하는 테스트 ")
    @ParameterizedTest
    @CsvSource(value = {"1 : true", "5 : true", "a : false"}, delimiter = ':')
    public void test(String source, boolean expected) {
        //given
        NumbersMock numbers = new NumbersMock();

        //when & then
        assertThat(numbers.isNumber(source)).isEqualTo(expected);
    }
}
