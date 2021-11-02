package calc;

import calc.operator.Add;
import calc.operator.Divide;
import calc.operator.Multiply;
import calc.operator.Operator;
import calc.operator.Subtract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 사칙연산 계산기 TEST
 * <p>
 * [조건]
 * 1. 문자와 연산 사이에 빈 공백이 존재
 * 2. 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로
 * 3. 우선순위는 입력 값의 순서에 따라 결정
 * <p>
 * [계산기 동작]
 * 1. Split 하여 String[] 배열을 얻는다.
 * 2.
 * <p>
 * [테스트 경우의 수]
 * 1-1. 단순 덧셈, 뺄셈, 곱셈, 나눗셈
 * 1-2. 복합 덧셈, 뺌셈, 곱셈, 나눗셈
 * TODO 2-1. 입력 값이 null 이거나 공백 문자인 경우
 * TODO 2-2. split 했을 때 원소의 개수가 짝수인 경우
 * TODO 3-1. 사칙연산자(+ - * /) 이외의 연산자가 있는 경우
 * TODO 3-2. 피연산자(0~9) 이외의 피연산자가 있는 경우
 * TODO 3-3. input 값을 split 하였을 때 odd 는 피연산자 even 은 연산자인지 확인
 * TODO 4-1. 0으로 나누는 경우
 * TODO 4-2. Overflow 가 발생하는 경우
 */

public class CalcTest {
    public static final String EMPTY_STRING = " ";
    public static final int EVEN = 0;

    Set<String> operandSet;
    Map<String, Operator> operatorMap;

    @BeforeEach
    void setUp() {
        operandSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            operandSet.add(Integer.valueOf(i).toString());
        }

        operatorMap = new HashMap<>();
        operatorMap.put("+", new Add());
        operatorMap.put("-", new Subtract());
        operatorMap.put("*", new Multiply());
        operatorMap.put("/", new Divide());
    }

    @ParameterizedTest
    @MethodSource("normalOperationSource")
    @DisplayName("단순 덧셈, 뺄셈, 곱셈, 나눗셈에 대한 테스트")
    void normalOperation(String input, int result) {
        int index = -1;
        final String[] raw = input.split(EMPTY_STRING);
        Deque<Integer> deque = new ArrayDeque<>();

        while (++index < raw.length) {
            if (index % 2 == EVEN) {
                deque.add(Integer.valueOf(raw[index]));
                continue;
            }

            Operator operator = operatorMap.get(raw[index]);
            int left = deque.poll();
            int right = Integer.parseInt(raw[++index]);
            deque.add(operator.operation(left, right));
        }

        assertThat(deque.peek()).isEqualTo(result);
    }

    static Stream<Arguments> normalOperationSource() {
        return Stream.of(
                Arguments.of("5", 5),
                Arguments.of("5 + 5", 10),
                Arguments.of("1 + 2 + 3", 6),
                Arguments.of("5", 5),
                Arguments.of("5 - 5", 0),
                Arguments.of("1 - 2 - 3", -4),
                Arguments.of("5", 5),
                Arguments.of("5 * 5", 25),
                Arguments.of("1 * 2 * 3", 6),
                Arguments.of("5", 5),
                Arguments.of("5 / 5", 1),
                Arguments.of("1 / 2 / 3", 0)
        );
    }
}
