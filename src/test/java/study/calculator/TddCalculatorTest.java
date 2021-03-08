package study.calculator;

import calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("TDD - 문자열 계산기")
public class TddCalculatorTest {

    private Operand operand;
    private TddCalculator tddCalculator;

    /**
     기능 요구사항
     1) 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
     2) 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
     3) 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
     4) 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
     5) 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

     프로그래밍 요구사항
      -> 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

     **리뷰어님의 피드백 사항**
      1) switch 지양하기
        -> enum 으로 대체하기
      2) 잘게 쪼갠 기능 테스트 필요
        -> 덧셈, 뺄셈, 곱셈 등등 테스트 추가
      3) 메소드 라인 수는 10 이내로 할 것.
      4) 연산자, 피연산자 클래스로 나눌 것
      ***5) 가장중요! 구현부터가 아닌 테스트코드부터 시작할 것 (구현부터하는 시작하는 SI 습관 버리기)
      6) 역할과 책임에 대한 생각
        -> 토끼 책 읽음. 독서실 마무리 후 집에서 잠자기전에 오브젝트 독서 예정
      7) 커스텀예외처리 만들어보기
        -> 사이즈 관련 예외를 커스텀으로 처리

     작업 목록
      -> 작은 단위로 나누어 구현 목록을 만든다.

     1) 작업함, 덧셈
     2) 작업함, 뺄셈
     3) 작업함, 곱셈
     4) 작업함, 나눗셈
     5) 작업함, 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
     6) 작업함, 숫자가 아닐 경우 NumberFormatException throw
     7) 작업함, 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
     8) 작업함, 사칙 연산을 모두 포함하는 기능 구현
     9) 작업함, 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
     10) 작업함, 문자 분리 후 사이즈 3 이상이여야 한다, 아닐 경우 OperandSizeException throw
     11) 작업함, 문자 분리 후 사이즈는 홀수여야 한다, 아닐 경우 OperandSizeException throw
     12) 작업함, 반복적인 패턴을 찾아 반복문으로 구현한다.
     */

    @BeforeEach
    public void setUp() {
        operand = new Operand();
        tddCalculator = new TddCalculator();
    }

    @Test
    @DisplayName("덧셈")
    public void plusTest() throws Exception {
        //given
        int a = 10;
        int b = 10;
        int result = 0;

        //when
        result = OperatorType.PLUS.operation(a, b);

        //then
        assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("뺄셈")
    public void minusTest() throws Exception {
        //given
        int a = 20;
        int b = 10;
        int result = 0;

        //when
        result = OperatorType.MINUS.operation(a, b);

        //then
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("곱셈")
    public void multiplyTest() throws Exception {
        //given
        int a = 6;
        int b = 8;
        int result = 0;

        //when
        result = OperatorType.MULTIPLY.operation(a, b);

        //then
        assertThat(result).isEqualTo(48);
    }

    @Test
    @DisplayName("나눗셈")
    public void divideTest() throws Exception {
        //given
        int a = 100;
        int b = 5;
        int result = 0;

        //when
        result = OperatorType.DIVIDE.operation(a, b);

        //then
        assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("입력값 쪼개기")
    public void inputValueSplit() throws Exception {
        //given
        String input = "1 + 2 + 5 + 10 / 9";

        //when
        String[] strArr = operand.stringToSplitStrArray(input);

        //then
        assertThat(strArr.length).isEqualTo(9);
    }

    @Test
    @DisplayName("입력값 숫자 확인")
    public void stringToIntTest() throws Exception {
        //given
        String input = "2";

        //when
        int result = operand.stringToInt(input);

        //then
        assertThat(result).isEqualTo(2);
    }


    @ParameterizedTest
    @ValueSource(strings = {"a", "b"})
    @DisplayName("입력값 숫자가 아닐 경우 에러 확인")
    public void stringToIntTest(String input) throws Exception {
        //given

        //when
        assertThatThrownBy(() -> {
            operand.stringToInt(input);
        }).isInstanceOf(NumberFormatException.class);

        //then
    }


    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @DisplayName("입력값 null 확인")
    public void stringNullCheckTest(String input) throws Exception {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            operand.stringNullCheck(input);
        });

        //then
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 +", "1 -", "1"})
    @DisplayName("쪼개진 값 사이즈 3 미만 여부확인")
    public void splitSize3DownValidTest(String input) throws Exception {
        //given
        String[] strArr = input.split(" ");

        //when
        Exception ex = assertThrows(Exception.class, () -> {
            operand.splitSize3DownValid(strArr);
        });

        //then
        assertThat(ex.getMessage()).isEqualTo(CalculatorErrorMessage.SIZE_THREE_DOWN_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 2 -", "1 - 2 * ", "1 * 10 +"})
    @DisplayName("쪼개진 값 사이즈 홀수 여부확인")
    public void dataSizeCheckTest(String input) throws Exception {
        //given
        String[] strArr = input.split(" ");

        //when
        OperandSizeException ex = assertThrows(OperandSizeException.class, () -> {
            operand.splitSizeEvenValid(strArr);
        });

        //then
        assertThat(ex.getMessage()).isEqualTo(CalculatorErrorMessage.SIZE_EVEN_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    @DisplayName("사칙연산 기호 확인")
    public void operationSymbolTest(String symbol) throws Exception {
        //given
        OperatorType oper;

        //when
        oper = OperatorType.findOper(symbol);

        //then
        assertThat(oper.getSymbol()).isEqualTo(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "1", "M", "aa"})
    @DisplayName("사칙연산 잘못된 기호 확인")
    public void operationSymbolErrorTest(String symbol) throws Exception {
        //given
        OperatorType oper;

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            OperatorType.findOper(symbol);
        });

        //then
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 1 + 2 * 5 / 5 - 111:-106", "10 + 1 + 2 / 5:2"}, delimiter = ':')
    @DisplayName("사칙연산 진행 확인")
    public void calcauloterTest(String input, int checkValue) throws Exception {
        //given
        int result = 0;

        //then
        result = tddCalculator.calculation(input);

        assertThat(result).isEqualTo(checkValue);
    }
}
