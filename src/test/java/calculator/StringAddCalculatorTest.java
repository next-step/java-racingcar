package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringAddCalculatorTest {
    private static final Logger log = Logger.getLogger("StringAddCalculatorTest");
    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    public void beforeEach() {
        stringAddCalculator = new StringAddCalculator();
    }

    /*
    투두리스트 목록
     */

    @DisplayName("빈 문자열 입력시 0을 반환해야 한다")
    @Test
    public void emptyStringInput() {
        //given
        String input = "";
        int answer = 0;
        //when
        int output = stringAddCalculator.splitAndSum(input);
        //then
        assertThat(output).isEqualTo(answer);
    }

    @DisplayName("null 값 입력시 0을 반환해야 한다")
    @Test
    public void nullStringInput() {
        //given
        String input = null;
        int answer = 0;
        //when
        int output = stringAddCalculator.splitAndSum(input);
        //then
        assertThat(output).isEqualTo(answer);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @Test
    public void 숫자_하나() {
        //given
        String input = "1";
        int answer = 1;
        //when
        int output = stringAddCalculator.splitAndSum(input);
        //then
        assertThat(output).isEqualTo(answer);
    }

    @DisplayName("10 이상의 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @Test
    public void 숫자_10이상_하나() {
        //given
        String input = "10";
        int answer = 10;
        //when
        int output = stringAddCalculator.splitAndSum(input);
        //then
        assertThat(output).isEqualTo(answer);
    }

    @DisplayName("자릿수가 긴 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @Test
    public void 숫자_큰걸로_하나() {
        //given
        Map<String, Integer> caseInputAndOutputMapper = Map.of(
            "100", 100,
            "737", 737,
            "787", 787,
            "350", 350,
            "380", 380,
            "142857", 142857
        );
        //when
        //then
        caseInputAndOutputMapper.keySet().forEach(input -> {
            assertThat(caseInputAndOutputMapper.get(input)).isEqualTo(stringAddCalculator.splitAndSum(input));
        });
    }


    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @Test
    public void 컴마구분자() {
        //given
        Map<String, Integer> caseInputAndOutputMapper = Map.of(
            "1,2,3", 6,
            "7,7,7", 21,
            "21,22,23", 66,
            "100,1,10,2000", 2111,
            "4444,333,2,1", 4780,
            "111111,11111,1111,111,11,1", 123456
        );
        //when
        //then
        caseInputAndOutputMapper.keySet().forEach(input -> {
            assertThat(caseInputAndOutputMapper.get(input)).isEqualTo(stringAddCalculator.splitAndSum(input));
        });
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    @Test
    public void 콜론구분자() {
        //given
        Map<String, Integer> caseInputAndOutputMapper = Map.of(
            "1:2:3", 6,
            "7:7:7", 21,
            "21:22:23", 66,
            "100:1:10:2000", 2111,
            "4444:333:2:1", 4780,
            "111111:11111:1111:111:11:1", 123456
        );
        //when
        //then
        caseInputAndOutputMapper.keySet().forEach(input -> {
            assertThat(caseInputAndOutputMapper.get(input)).isEqualTo(stringAddCalculator.splitAndSum(input));
        });
    }

    @DisplayName("구분자를 컴마(,) 와 콜론(:)을 함께 사용할 수 있다")
    @Test
    public void 콜론과_컴마구분자() {
        //given
        Map<String, Integer> caseInputAndOutputMapper = Map.of(
            "1,2:3", 6,
            "7,7:7", 21,
            "21:22,23", 66,
            "100:1:10,2000", 2111,
            "4444:333,2:1", 4780,
            "111111:11111,1111:111:11:1", 123456
        );
        //when
        //then
        caseInputAndOutputMapper.keySet().forEach(input -> {
            assertThat(caseInputAndOutputMapper.get(input)).isEqualTo(stringAddCalculator.splitAndSum(input));
        });
    }

    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : ")
    @Test
    public void 커스텀구분자() {
        //given
        String input = "//;\n1;2;3";
        int answer = 6;
        //when
        int output = stringAddCalculator.splitAndSum(input);
        //then
        assertThat(output).isEqualTo(answer);
    }

    @DisplayName("커스텀 구분자 사용시 큰 자리수 테스트")
    @Test
    public void 커스텀구분자복잡() {
        //given
        String input = "//;\n111111;222222;333333";
        int answer = 666666;
        //when
        int output = stringAddCalculator.splitAndSum(input);
        //then
        assertThat(output).isEqualTo(answer);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다")
    @Test
    public void 음수예외() {
        //given
        String input = "-1,2,3";
        //when
        //then
        assertThatThrownBy(() -> {
            stringAddCalculator.splitAndSum(input);
        }).isInstanceOf(RuntimeException.class);
    }

}
