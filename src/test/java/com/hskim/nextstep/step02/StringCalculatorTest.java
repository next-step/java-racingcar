package com.hskim.nextstep.step02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

/*
    com.hskim.nextstep.step02 - StringCalculator class 테스트
 */
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {

        stringCalculator = new StringCalculator();
    }

    private static Stream<Queue<String>> provideInvalidExprQueue() {

        Queue<String> emptyQueue = new LinkedList<>();
        emptyQueue.addAll(Arrays.asList("", " "));
        Queue<String> containsInvalidQueue = new LinkedList<>();
        containsInvalidQueue.addAll(Arrays.asList("2", "+", "3", "/", "5", ")")); // contains invalid sign ')'

        return Stream.of(
                emptyQueue,
                null,
                containsInvalidQueue
        );
    }

    private static Stream<Arguments> provideValidExprQueue() {

        Queue<String> mockExprQueue1 = new LinkedList<>();
        mockExprQueue1.addAll(Arrays.asList("2", "+", "3", "*", "4", "/", "2"));
        Queue<String> mockExprQueue2 = new LinkedList<>();
        mockExprQueue2.addAll(Arrays.asList("5", "*", "7", "-", "5", "+", "6", "/", "2"));
        Queue<String> mockExprQueue3 = new LinkedList<>();
        mockExprQueue3.addAll(Arrays.asList("8", "/", "2", "*", "9", "+", "3", "-", "38"));

        return Stream.of(
                Arguments.of(mockExprQueue1, 10),
                Arguments.of(mockExprQueue2, 18),
                Arguments.of(mockExprQueue3, 1)
        );
    }

    @DisplayName("calculate()메소드 입력값이 null이거나 공백인 경우 테스트 ")
    @ParameterizedTest
    @MethodSource("provideInvalidExprQueue")
    void calculateInvalidArgumentTest(Queue<String> exprQueue) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculate(exprQueue);
        });
    }

    @DisplayName("calculate()메소드 입력값이 정상인 경우 테스트")
    @ParameterizedTest
    @MethodSource("provideValidExprQueue")
    void calculateValidArgumentTest(Queue<String> exprQueue, int expected) {

        assertThat(stringCalculator.calculate(exprQueue)).isEqualTo(expected);
    }

}
