package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleCalculatorTest {
    List<Character> opList = new ArrayList<>();
    List<Character> numList  = new ArrayList<>();

    @BeforeEach
    void setUp() {
        opList = new ArrayList<>();
        numList  = new ArrayList<>();
        opList.add('+');
        opList.add('-');
        opList.add('*');
        opList.add('/');

        for (int i = 0 ; i <= 9 ; i++) {
            numList.add((char)('0' + i));
        }
    }

    @Test
    @DisplayName("입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열여부를 테스트")
    void shouldExistSpaceBetweenEachChar() {
        String input = "2 + 3 * 4 / 2";
        String badInput = "2+ 3 *4 /2";

        for (int i = 0 ; i < input.length() - 1 ; i++) {
            char currChar = input.charAt(i);
            char nextChar = input.charAt(i+1);

            if (numList.contains(currChar)) {
                assertThat(opList.contains(nextChar)).isFalse();
                assertThat(nextChar).isEqualTo(' ');
            }

            if (opList.contains(currChar)) {
                assertThat(numList.contains(nextChar)).isFalse();
                assertThat(nextChar).isEqualTo(' ');
            }
        }
    }

    @Test
    @DisplayName("더하기 테스트")
    void plusTest() {
        String input = "1 + 2";

    }

    @Test
    @DisplayName("'Num Op Num' 으로 구성된 수식을 Num으로 만들기")
    void proceedCalculationTest() {

    }


    @Test
    @DisplayName("나눗셈의 경우 결과 값이 정수로 떨어지는 값인지 테스트")
    void shouldBeZeroOfRemainderAfterDividing() {
    }
}
