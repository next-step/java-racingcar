package calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculator {

    /*
    1. 숫자 배열을 생성하도록 split 한다. numbers = String#split("+\-*")
    2. 부호 배열을 생성하도록 split 한다. operations = String#split("\\d")
    3. 주어진 식의 맨 앞이 - 로 시작하는지 확인한다. String#startswith("-")
        3-1. 만약 - 로 시작하면
            3-1-1. numbers.length == operations.length 을 확인(throw IllegalArgumentException)
            3-1-2. 첫 번째 숫자에 - 를 곱하고, operationIndex 를 1로 설정
        3-2. 그렇지 않으면 numbers.length - 1 == operations.length 을 확인(throw IllegalArgumentException)
    4. 반복문으로 numbers[numberIndex] 와 [numberIndex + 1] 을 operations[operationIndex] 를 이용하여 계산
        4-1. 중간에 사칙연산이 아닌 부호를 만난다면 throw IllegalArgumentException
     */

    @Test
    @DisplayName("양수만 있는 문자열 테스트")
    public void 양수만_있는_문자열_테스트() {

    }
}
