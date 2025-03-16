package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        // 각 테스트 실행 전에 StringAddCalculator 객체 초기화
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    void splitNumbersTest() {
        // 쉼표(,) 또는 콜론(:)을 구분자로 숫자를 구분하는 메소드 테스트

        // "" => []
        // "1,2" => [1,2]
        // "1,2:3" => [1,2,3]

        // assertArrayEquals(expectedArray, actualArray);
//        assertArrayEquals(new int[]{}, stringAddCalculator.splitNumbers(""));
        assertArrayEquals(new int[]{1, 2}, stringAddCalculator.splitNumbers("1,2", stringAddCalculator.filterSeparators("1,2")));
        assertArrayEquals(new int[]{1, 2, 3}, stringAddCalculator.splitNumbers("1,2:3", stringAddCalculator.filterSeparators("1,2")));
    }

    @Test
    void addNumbersInArrayTest() {
        // 분리된 숫자들 배열 속 요소들을 더한 값을 산출하는 메소드 테스트

        // [] => 0
        // [1,2] => 3
        // [1,2,3] => 6
        assertEquals(0, stringAddCalculator.addNumbersInArray(new int[]{}));
        assertEquals(3, stringAddCalculator.addNumbersInArray(new int[]{1, 2}));
        assertEquals(6, stringAddCalculator.addNumbersInArray(new int[]{1, 2, 3}));

    }

    @Test
    void filterSeparatorsTest() throws Exception {
        // 구분자를 찾아내는 메소드 테스트(커스텀 구분자 경우 포함)

        // "//;\n1;2;3" => ",:;"
        // "//#\n1#2#3" => ",:#"
        // "1,2:3" => ",:"

        assertEquals(",:;",  stringAddCalculator.filterSeparators("//;\n1;2;3"));
        assertEquals(",:#",  stringAddCalculator.filterSeparators("//#\n1#2#3"));
        assertEquals(",:",  stringAddCalculator.filterSeparators("1,2:3"));
    }

    @Test
    void extractNumbersTest() {
        // 커스텀 메소드를 포함하는 문자열의 경우, 위 테스트에 사용된 메소드들을 사용해 적절한 결과 도출 확인 테스트

        // "//;\n1;2;3" => [1,2,3]
        stringAddCalculator.checkIfOnlyNumbers("1:2:3");
        stringAddCalculator.checkIfOnlyNumbers("//;\n1;2;3");
    }

    @Test
    void checkIfInputsAreNumbersTest() {
        // 숫자가 아닌 값이 들어오면 오류

        // "a,b,c" => error
        // "NaN:e:log" => error
    }

    @Test
    void checkIfInputsArePositiveNumbersTest() {
        // 숫자가 아닌 값이 들어오면 오류

        // "-1,-2" => error
    }

    @Test
    void checkIfValidCustomSeparatorTest() {
        // 숫자가 아닌 값이 들어오면 오류

        // "//;//1;2;3" => error
        // "\n;\n1;2;3" => error
    }


}
