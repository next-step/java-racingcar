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
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 사칙연산 계산기 TEST
 * <p>
 * [조건]
 * 1. 문자와 연산 사이에 빈 공백이 존재
 * 2. 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로
 * 3. 우선순위는 입력 값의 순서에 따라 결정
 * <p>
 * [테스트 경우의 수]
 * 1. 단순 덧셈, 뺄셈, 곱셈, 나눗셈, 복합연산
 * 2-1. 입력 값이 null 인 경우
 * 2-2. 입력 값이 공백 문자인 경우
 * 2-3. split 했을 때 원소의 개수가 짝수인 경우
 * 3-1. 사칙연산자(+ - * /) 이외의 연산자가 있는 경우
 * 3-2. 피연산자(0~9) 이외의 피연산자가 있는 경우
 * 4-1. 0으로 나누는 경우
 * TODO 4-2. 계산 중 Overflow 가 발생하는 경우
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
    @MethodSource("basicOperationSource")
    @DisplayName("단순 덧셈, 뺄셈, 곱셈, 나눗셈, 복합연산에 대한 테스트")
    void basicOperation(String input, int result) {
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

    static Stream<Arguments> basicOperationSource() {
        return Stream.of(
                Arguments.of("5", 5),
                Arguments.of("5 + 5", 10),
                Arguments.of("1 + 2 + 3", 6),
                Arguments.of("5 - 5", 0),
                Arguments.of("1 - 2 - 3", -4),
                Arguments.of("5 * 5", 25),
                Arguments.of("1 * 2 * 3", 6),
                Arguments.of("5 / 5", 1),
                Arguments.of("1 / 2 / 3", 0),
                Arguments.of("10 + 2 - 3 * 4 / 5", 7)
        );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("입력 값이 null 인 경우")
    void inputSourceNull(String input) {
        assertThatThrownBy(() -> {
            if (input == null) {
                throw new IllegalArgumentException();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @DisplayName("입력 값이 공백인 경우")
    void inputSourceEmpty(String input) {
        assertThatThrownBy(() -> {
            if (input.trim().equals("")) {
                throw new IllegalArgumentException();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"5 +", "5 - 1 *"})
    @DisplayName("split 했을 때 원소의 개수가 짝수인 경우")
    void evenElement(String input) {
        assertThatThrownBy(() -> {
            if (input.split(EMPTY_STRING).length % 2 == 0) {
                throw new IllegalArgumentException();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 ^ 3", "5 +- 30"})
    @DisplayName("사칙연산자(+ - * /) 이외의 연산자가 있는 경우")
    void notSupportedOperator(String input) {
        final String[] raw = input.split(EMPTY_STRING);
        assertThatThrownBy(() -> {
            for (int i = 1; i < raw.length; i += 2) {
                if (!operatorMap.containsKey(raw[i])) {
                    throw new IllegalArgumentException();
                }
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a ^ 3", "[ + 30"})
    @DisplayName("피연산자(0~9) 이외의 피연산자가 있는 경우")
    void notSupportedOperand(String input) {
        final String[] raw = input.split(EMPTY_STRING);
        assertThatThrownBy(() -> {
            for (int i = 0; i < raw.length; i += 2) {
                if (!operandSet.contains(raw[i])) {
                    throw new IllegalArgumentException();
                }
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 / 0", "5 * 30 / 0"})
    @DisplayName("0으로 나누는 경우")
    void divideByZero(String input) {
        assertThatThrownBy(() -> {
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

                if (right == 0) {
                    throw new IllegalArgumentException();
                }

                deque.add(operator.operation(left, right));
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
